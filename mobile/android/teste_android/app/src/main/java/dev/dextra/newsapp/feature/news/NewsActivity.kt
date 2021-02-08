package dev.dextra.newsapp.feature.news

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import dev.dextra.newsapp.R
import dev.dextra.newsapp.api.model.Article
import dev.dextra.newsapp.api.model.Source
import dev.dextra.newsapp.api.repository.NewsRepository
import dev.dextra.newsapp.base.repository.EndpointService
import dev.dextra.newsapp.feature.news.adapter.ArticleListAdapter
import kotlinx.android.synthetic.main.activity_news.*


const val NEWS_ACTIVITY_SOURCE = "NEWS_ACTIVITY_SOURCE"

class NewsActivity : AppCompatActivity() {

    private val newsViewModel = NewsViewModel(NewsRepository(EndpointService()), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_news)

        (intent?.extras?.getSerializable(NEWS_ACTIVITY_SOURCE) as Source).let { source ->
            title = source.name

            loadNews(source)
        }

        super.onCreate(savedInstanceState)

    }

    private fun loadNews(source: Source) {
        newsViewModel.configureSource(source)
        newsViewModel.loadNews()
    }

    fun onClick(article: Article) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(article.url)
        startActivity(i)
    }

    private var loading: Dialog? = null

    fun showLoading() {
        if (loading == null) {
            loading = Dialog(this)
            loading?.apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                window.setBackgroundDrawableResource(android.R.color.transparent)
                setContentView(R.layout.dialog_loading)
            }
        }
        loading?.show()
    }

    fun hideLoading() {
        loading?.dismiss()
    }

    fun showData(articles: List<Article>) {
        val viewAdapter = ArticleListAdapter(this@NewsActivity, this@NewsActivity, articles)
        news_list.adapter = viewAdapter
    }
}
