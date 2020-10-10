package com.fastnews.repository

import com.fastnews.service.api.RedditAPI
import com.fastnews.service.model.PostData

object PostRepository : BaseRepository() {

    suspend fun getPosts(after: String, limit: Int): List<PostData> {

        val postResponse = safeApiCall(
            call = { RedditAPI.redditService.getPostList(after, limit).await() },
            errorMessage = "Error to fetching posts"
        )

        val result: MutableList<PostData> = mutableListOf()
        postResponse?.data?.children?.map { postChildren -> result.add(postChildren.data) }

        return result

    }
}