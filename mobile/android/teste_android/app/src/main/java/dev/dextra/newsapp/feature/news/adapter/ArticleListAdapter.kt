package dev.dextra.newsapp.feature.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import dev.dextra.newsapp.R
import dev.dextra.newsapp.api.model.Article
import dev.dextra.newsapp.feature.news.NewsActivity
import kotlinx.android.synthetic.main.item_article.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ArticleListAdapter(
    context: Context,
    val listener: NewsActivity,
    articles: List<Article>) : ArrayAdapter<Article>(context, 0, articles) {

    private val dateFormat = SimpleDateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.SHORT)
    private val parseFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val article = getItem(position)

        var convertView2 = convertView

        if (convertView2 == null) {
            convertView2 = LayoutInflater.from(getContext()).inflate(R.layout.item_article, parent, false)
        }

        if(convertView2!=null){
            convertView2.rootView.article_name.text = article.title
            convertView2.rootView.article_description.text = article.description
            convertView2.rootView.article_author.text = article.author
            convertView2.rootView.article_date.text = dateFormat.format(parseFormat.parse(article.publishedAt))
            convertView2.setOnClickListener{listener.onClick(article)}
        }

        return convertView2!!
    }
}