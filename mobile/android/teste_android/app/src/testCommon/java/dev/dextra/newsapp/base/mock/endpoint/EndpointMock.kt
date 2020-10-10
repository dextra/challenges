package dev.dextra.newsapp.base.mock.endpoint

import dev.dextra.newsapp.base.mock.MockedEndpointService
import okhttp3.Request
import retrofit2.HttpException

//this is the object which mocks an URL
class EndpointMock(val url: String, val endpointService: MockedEndpointService?) {
    protected var responseHandler: ResponseHandler? = null
    protected var response: String? = null
    private var code = 200
    var error: HttpException? = null
        private set
    private var method: String? = null

    fun getCode(): Int {
        return code
    }

    fun getResponse(request: Request): String {
        if (responseHandler != null) {
            return responseHandler!!.getResponse(request, url)
        }
        return response ?: ""
    }

    fun throwConnectionError(): EndpointMock {
        this.code = FORCED_MOCK_EXCEPTION_CODE
        return this
    }

    //the response code this mock should send
    fun code(code: Int): EndpointMock {
        this.code = code
        return this
    }

    //the response body this mock should send
    fun body(response: String): EndpointMock {
        this.response = response
        return this
    }

    //a handler to mock dynamically with multiple cases
    fun body(handler: ResponseHandler): EndpointMock {
        this.responseHandler = handler
        return this
    }

    //set the EndpointMock and make it active
    fun apply() {
        endpointService?.let {
            var path = url
            if (method != null) {
                path = "$method $path"
            }
            endpointService.addMockedEndpoint(path, this)
        } ?: throw RuntimeException("EndpointService not mocked!")

    }

    companion object {
        val FORCED_MOCK_EXCEPTION_CODE = 999
    }
}
