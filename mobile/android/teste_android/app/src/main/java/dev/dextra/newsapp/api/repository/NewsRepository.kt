package dev.dextra.newsapp.api.repository

import dev.dextra.newsapp.api.model.ArticlesResponse
import dev.dextra.newsapp.api.model.SourceResponse
import dev.dextra.newsapp.base.repository.EndpointService
import dev.dextra.newsapp.base.repository.Repository
import io.reactivex.Single

class NewsRepository(endpointService: EndpointService) : Repository<NewsEndpoint>(endpointService) {

    fun getSources(country: String?, category: String?): Single<SourceResponse> {
        return schedule(getEndpoint().getSources(country, category))
    }

    fun getEverything(sources: String?, page: Int = 1, pageSize: Int = 20): Single<ArticlesResponse> {
        return schedule(getEndpoint().getEverything(sources, page, pageSize))
    }
}