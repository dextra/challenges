package dev.dextra.newsapp.base

import dev.dextra.newsapp.base.mock.MockedEndpointService
import dev.dextra.newsapp.base.mock.endpoint.EndpointMock
import dev.dextra.newsapp.base.repository.EndpointService
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.mock.declare

object TestSuite : KoinTest{

    var endpointService: MockedEndpointService? = null
        private set

    fun mock(url: String): EndpointMock {
        var url = url
        if (!url.startsWith("/") && !url.startsWith("http")) {
            url = "/$url"
        }
        return EndpointMock(url, endpointService)
    }

    fun clearEndpointMocks() {
        endpointService!!.clearMocks()
    }

    //set the MockedEndpointService with Koin
    private fun initMockedEndpointService() {
        endpointService = MockedEndpointService()

        declare {
            single { endpointService as EndpointService }
        }
    }

    //check if the test is Instrumented or Unit, in Unit tests we set RxJava to run synchronously
    fun init(instrumented: Boolean) {
        GlobalContext.getOrNull() ?: startKoin { modules(appComponent) }

        if(!instrumented) RxTestScheduler.init()

        initMockedEndpointService()
    }

    fun clear() {
        clearEndpointMocks()
        stopKoin()
    }

}
