package dev.dextra.newsapp.api.repository

import dev.dextra.newsapp.api.model.ArticlesResponse
import dev.dextra.newsapp.api.model.SourceResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsEndpoint {

    @GET("/v2/sources")
    fun getSources(@Query("country") country: String?, @Query("category") category: String?): Single<SourceResponse>

    @GET("/v2/everything")
    fun getEverything(@Query("sources") sources: String?, @Query("page") page: Int, @Query("pageSize") pageSize: Int ): Single<ArticlesResponse>

}