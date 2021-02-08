package com.fastnews.repository

import com.fastnews.service.api.RedditAPI
import com.fastnews.service.model.CommentData

object CommentRepository : BaseRepository() {

    const val PREFIX_COMMENT = "t1"

    suspend fun getComments(postId: String): List<CommentData> {

        val commentsResponse = safeApiCall(
            call = { RedditAPI.redditService.getCommentList(postId).await() },
            errorMessage = "Error to fetch comments from postId -> $postId"
        )

        val result = mutableListOf<CommentData>()
        commentsResponse?.map { response ->
            response.data.children.map { data ->
                if (data.kind == PREFIX_COMMENT) {
                    result.add(data.data)
                }
            }
        }

        return result

    }

}