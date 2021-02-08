package dev.dextra.newsapp.api.model
import com.google.gson.annotations.SerializedName


data class ArticlesResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)