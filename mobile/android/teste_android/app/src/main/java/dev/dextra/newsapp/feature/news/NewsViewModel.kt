package dev.dextra.newsapp.feature.news

import dev.dextra.newsapp.api.model.Source
import dev.dextra.newsapp.api.repository.NewsRepository
import dev.dextra.newsapp.base.BaseViewModel


class NewsViewModel(
    private val newsRepository: NewsRepository,
    private val newsActivity: NewsActivity
) : BaseViewModel() {

    private var source: Source? = null

    fun configureSource(source: Source) {
        this.source = source
    }

    fun loadNews() {
        newsActivity.showLoading()
        addDisposable(
            newsRepository.getEverything(source!!.id).subscribe({ response ->
                newsActivity.showData(response.articles)
                newsActivity.hideLoading()
            },
                {
                    newsActivity.hideLoading()
                })
        )
    }
}
