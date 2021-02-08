package com.fastnews.viewmodel

import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fastnews.mechanism.Coroutines
import com.fastnews.repository.CommentRepository
import com.fastnews.repository.PostRepository
import com.fastnews.service.model.CommentData
import com.fastnews.service.model.PostData

class CommentViewModel : ViewModel() {

    private lateinit var comments: MutableLiveData<List<CommentData>>

    @UiThread
    fun getComments(postId: String): LiveData<List<CommentData>> {
        if(!::comments.isInitialized) {
            comments = MutableLiveData()

            Coroutines.ioThenMain({
                CommentRepository.getComments(postId)
            }) {
                comments.postValue(it)
            }
        }
        return comments
    }

}