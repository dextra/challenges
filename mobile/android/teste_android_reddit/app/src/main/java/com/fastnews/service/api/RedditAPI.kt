package com.fastnews.service.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RedditAPI {
    var API_BASE_URL: String = "https://www.reddit.com/r/Android/"
    var httpClient = OkHttpClient.Builder()

    var builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())

    var retrofit = builder
        .client(httpClient.build())
        .build()

    var redditService = retrofit.create<RedditService>(
        RedditService::class.java)

}