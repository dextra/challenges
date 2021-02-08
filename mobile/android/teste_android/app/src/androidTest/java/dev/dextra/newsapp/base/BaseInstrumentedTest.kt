package dev.dextra.newsapp.base

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import dev.dextra.newsapp.R

open class BaseInstrumentedTest : BaseTest(true) {

    internal fun waitLoading() {
        //TODO replace with IdlingResource
        Thread.sleep(100)
        while (isLoadingVisible()) {
            Thread.sleep(200)
        }

    }

    private fun isLoadingVisible(): Boolean {
        try {
            Espresso.onView(ViewMatchers.withId(R.id.custom_loading_imageView))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            return true
        } catch (ignored: Throwable) {
        }
        return false
    }

}