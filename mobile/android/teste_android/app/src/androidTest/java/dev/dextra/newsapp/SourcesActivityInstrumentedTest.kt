package dev.dextra.newsapp

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import dev.dextra.newsapp.api.model.Source
import dev.dextra.newsapp.api.model.SourceResponse
import dev.dextra.newsapp.api.model.enums.Category
import dev.dextra.newsapp.api.model.enums.Country
import dev.dextra.newsapp.base.BaseInstrumentedTest
import dev.dextra.newsapp.base.FileUtils
import dev.dextra.newsapp.base.TestSuite
import dev.dextra.newsapp.base.mock.endpoint.ResponseHandler
import dev.dextra.newsapp.feature.sources.SourcesActivity
import dev.dextra.newsapp.utils.JsonUtils
import okhttp3.Request
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.RuntimeException

@RunWith(AndroidJUnit4::class)
class SourcesActivityInstrumentedTest : BaseInstrumentedTest() {

    val emptyResponse = SourceResponse(ArrayList(), "ok")
    val brazilResponse = SourceResponse(listOf(Source("cat", "BR", "Test Brazil Description", "1234", "PT", "Test Brazil", "http://www.google.com.br")), "ok")

    @get:Rule
    val activityRule = ActivityTestRule(SourcesActivity::class.java, false, false)

    @Before
    fun setupTest() {
        //we need to lauch the activity here so the MockedEndpointService is set
        activityRule.launchActivity(null)
        Intents.init()
    }

    @Test
    fun testCountrySelectorWithStates() {
        //dynamic mock, BR = customResponse, US = empty response and CA = error response, everything else is the default json
        TestSuite.mock(TestConstants.sourcesURL).body(object : ResponseHandler {
            override fun getResponse(request: Request, path: String): String {
                val jsonData = FileUtils.readJson(path.substring(1) + ".json")!!
                return request.url().queryParameter("country")?.let {
                    when (it) {
                        Country.BR.name.toLowerCase() -> {
                            JsonUtils.toJson(brazilResponse)
                        }
                        Country.US.name.toLowerCase() -> {
                            JsonUtils.toJson(emptyResponse)
                        }
                        Country.CA.name.toLowerCase() -> {
                            throw RuntimeException()
                        }
                        else -> {
                            jsonData
                        }
                    }
                } ?: jsonData
            }
        }).apply()


        waitLoading()

        //select Brazil in the country list
        onView(withId(R.id.country_select)).perform(ViewActions.click())
        onData(equalTo(Country.BR)).inRoot(RootMatchers.isPlatformPopup()).perform(click())

        waitLoading()

        //check if the Sources list is displayed with the correct item and the empty and error states are hidden
        onView(withId(R.id.sources_list)).check(matches(isDisplayed()))
        onView(withId(R.id.error_state)).check(matches(not(isDisplayed())))
        onView(withId(R.id.empty_state)).check(matches(not(isDisplayed())))
        onView(ViewMatchers.withChild(ViewMatchers.withText("Test Brazil"))).check(matches(isDisplayed()))

        //select United States in the country list
        onView(withId(R.id.country_select)).perform(ViewActions.click())
        onData(equalTo(Country.US)).inRoot(RootMatchers.isPlatformPopup()).perform(click())

        waitLoading()

        //check if the empty state is displayed with the correct item and the source list and error state are hidden
        onView(withId(R.id.empty_state)).check(matches(isDisplayed()))
        onView(withId(R.id.error_state)).check(matches(not(isDisplayed())))
        onView(withId(R.id.sources_list)).check(matches(not(isDisplayed())))

        //select Canada in the country list
        onView(withId(R.id.country_select)).perform(ViewActions.click())
        onData(equalTo(Country.CA)).inRoot(RootMatchers.isPlatformPopup()).perform(click())

        waitLoading()

        //check if the error state is displayed with the correct item and the source list and empty state are hidden
        onView(withId(R.id.error_state)).check(matches(isDisplayed()))
        onView(withId(R.id.empty_state)).check(matches(not(isDisplayed())))
        onView(withId(R.id.sources_list)).check(matches(not(isDisplayed())))

        //clear the mocks to use just the json files
        TestSuite.clearEndpointMocks()

        //retry in the error state
        onView(withId(R.id.error_state_retry)).perform(ViewActions.click())

        waitLoading()

        //check if the Sources list is displayed and the empty and error states are hidden
        onView(withId(R.id.sources_list)).check(matches(isDisplayed()))
        onView(withId(R.id.error_state)).check(matches(not(isDisplayed())))
        onView(withId(R.id.empty_state)).check(matches(not(isDisplayed())))

    }

    @Test
    fun testCategorySelectorWithStates() {
        //dynamic mock, if any category besides ALL is selected, show a custom response
        TestSuite.mock(TestConstants.sourcesURL).body(object : ResponseHandler {
            override fun getResponse(request: Request, path: String): String {
                val jsonData = FileUtils.readJson(path.substring(1) + ".json")!!
                return request.url().queryParameter("category")?.let {
                    if(it==Category.BUSINESS.name.toLowerCase()) JsonUtils.toJson(brazilResponse) else jsonData
                } ?: jsonData
            }
        }).apply()

        waitLoading()

        //select the Business category
        onView(withId(R.id.category_select)).perform(ViewActions.click())
        onData(equalTo(Category.BUSINESS)).inRoot(RootMatchers.isPlatformPopup()).perform(click())

        waitLoading()

        //check if the Sources list is displayed with the correct item and the empty and error states are hidden
        onView(withId(R.id.sources_list)).check(matches(isDisplayed()))
        onView(withId(R.id.error_state)).check(matches(not(isDisplayed())))
        onView(withId(R.id.empty_state)).check(matches(not(isDisplayed())))
        onView(ViewMatchers.withChild(ViewMatchers.withText("Test Brazil"))).check(matches(isDisplayed()))

    }


    @After
    fun clearTest() {
        Intents.release()
    }

}