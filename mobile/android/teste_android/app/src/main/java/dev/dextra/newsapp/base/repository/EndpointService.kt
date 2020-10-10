package dev.dextra.newsapp.base.repository

import dev.dextra.newsapp.API_KEY
import dev.dextra.newsapp.API_KEY_HEADER_NAME
import dev.dextra.newsapp.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

open class EndpointService {

    private var retrofit: Retrofit? = null
    private val services = HashMap<Class<*>, Any?>()
    private var httpClient: OkHttpClient? = null

    //configure retrofit
    private fun getRetrofit(): Retrofit {
        return retrofit ?: let {

            retrofit = Retrofit.Builder()
                .client(getHttpClient())
                .baseUrl(getBaseURL())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit as Retrofit
        }
    }

    protected open fun getBaseURL() = BASE_URL

    private fun getHttpClient(): OkHttpClient {
        return httpClient ?: let {
            httpClient = getBuilder().build()
            return httpClient as OkHttpClient
        }
    }

    protected open fun getBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(logging)
        builder.addInterceptor(::addHeaders)

        return builder
    }

    //add the API_KEY header
    private fun addHeaders(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().addHeader(API_KEY_HEADER_NAME, API_KEY).build()
        return chain.proceed(request)
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T> get(endpointClass: Class<T>): T {
        var endpoint: Any? = services[endpointClass]
        if (endpoint == null) {
            endpoint = getRetrofit().create(endpointClass)
            services[endpointClass] = endpoint
        }
        return endpoint as T
    }
}