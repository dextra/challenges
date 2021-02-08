package dev.dextra.newsapp.base.mock

import android.util.Log
import dev.dextra.newsapp.base.FileUtils
import dev.dextra.newsapp.base.mock.endpoint.EndpointMock
import dev.dextra.newsapp.base.repository.EndpointService
import okhttp3.*
import java.util.*

class MockedEndpointService : EndpointService() {

    private val JSON_MEDIA_TYPE = MediaType.parse("application/json")
    private val mockedEndpoints = HashMap<String, EndpointMock>()

    //we override the get builder method and use an interceptor
    //so instead of getting the data from the api it's going to load the data from JSON files
    override fun getBuilder(): OkHttpClient.Builder {
        val builder = super.getBuilder()
        builder.addInterceptor(mockInterceptor())
        return builder
    }

    override fun getBaseURL() = "http://MOCKED.net"

    private fun mockInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val path = getPath(request)

            val endpoint = request.method().toUpperCase() + " " + path
            var mock: EndpointMock? = mockedEndpoints[endpoint]
            if (mock == null) {
                mock = mockedEndpoints[path]
            }
            if (mock != null) {
                return@Interceptor customResponse(chain, mock)
            }

            defaultResponse(chain, path)
        }
    }

    private fun getPath(request: Request): String {
        var path = request.url().encodedPath()
        if ("/" == path) {
            path = request.url().toString()
        }
        return path
    }

    //custom responses are dynamic mocks, you can create it in the test code
    private fun customResponse(chain: Interceptor.Chain, mock: EndpointMock): Response {
        val builder = defaultBuilder(chain)

        if (mock.getCode() == EndpointMock.FORCED_MOCK_EXCEPTION_CODE) {
            throw RuntimeException("EndpointMock test exception")
        }
        return mock.error?.let { error ->
            builder.code(mock.getCode())
                .body(error.response().errorBody())
                .build()
        } ?: builder.code(mock.getCode())
            .body(ResponseBody.create(JSON_MEDIA_TYPE, mock.getResponse(chain.request())))
            .build()
    }

    //default response is getting the response from JSON files
    private fun defaultResponse(chain: Interceptor.Chain, endpoint: String): Response {
        val builder = defaultBuilder(chain)

        val content = FileUtils.readJson(endpoint.substring(1) + ".json") ?: return endpointNotMocked(endpoint)
        return builder.code(200)
            .body(ResponseBody.create(JSON_MEDIA_TYPE, content))
            .build()
    }

    private fun defaultBuilder(chain: Interceptor.Chain): Response.Builder {
        val builder = Response.Builder()
        return builder.message("")
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
    }

    private fun endpointNotMocked(endpoint: String): Response {
        Log.e("MockedEndpointService", "endpoint not mocked -> $endpoint")
        throw RuntimeException("endpoint not mocked -> $endpoint")
    }

    fun addMockedEndpoint(url: String, mock: EndpointMock) {
        mockedEndpoints[url] = mock
    }

    fun clearMocks() {
        mockedEndpoints.clear()
    }
}