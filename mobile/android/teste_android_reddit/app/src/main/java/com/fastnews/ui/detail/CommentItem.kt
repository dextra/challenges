package com.fastnews.ui.detail

import android.animation.Animator
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import com.fastnews.R
import com.fastnews.mechanism.TimeElapsed
import com.fastnews.service.model.CommentData
import kotlinx.android.synthetic.main.item_detail_post_comment.view.*

class CommentItem(val activity: Activity, private val postComment: CommentData) {

    private var row: View = LayoutInflater.from(activity).inflate(R.layout.item_detail_post_comment, null, false)

    private var isVisible: Boolean = false

    companion object {
        fun newInstance(activity: Activity, postComment: CommentData): View {
            return CommentItem(activity, postComment).build()
        }
    }

    fun build(): View {
        populateCommentsIcon()
        populateTimeLeftText()
        populateTimeLeftValue()
        populateCommentBody()
        populateScoreUp()
        populateScoreDown()
        return row
    }

    private fun populateCommentsIcon() {
        row.setOnClickListener {
            isVisible = !isVisible
            if (isVisible) {
                row.item_comment_container.animate().alpha(0.0f).setDuration(500).setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animator: Animator) {}

                    override fun onAnimationEnd(animator: Animator) {
                        row.item_comment_container.visibility = View.GONE
                        row.ic_comments.setImageDrawable(activity.getDrawable(R.drawable.ic_comments_down))
                    }

                    override fun onAnimationCancel(animator: Animator) {

                    }

                    override fun onAnimationRepeat(animator: Animator) {

                    }
                })
            } else {
                row.item_comment_container.animate().alpha(1.0f).setDuration(500).setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animator: Animator) {}

                    override fun onAnimationEnd(animator: Animator) {
                        row.item_comment_container.visibility = View.VISIBLE
                        row.ic_comments.setImageDrawable(activity.getDrawable(R.drawable.ic_comments_up))
                    }

                    override fun onAnimationCancel(animator: Animator) {

                    }

                    override fun onAnimationRepeat(animator: Animator) {

                    }
                })
            }
        }
    }

    private fun populateTimeLeftText() {
        row.item_comment_author.text = postComment.author
    }

    private fun populateTimeLeftValue() {
        val elapsed = TimeElapsed.getTimeElapsed(postComment.created_utc)
        row.item_comment_timeleft.text = elapsed
    }

    private fun populateCommentBody() {
        row.item_comment_body.text = postComment.body
    }

    private fun populateScoreUp() {
        row.item_comment_score_up.text = postComment.ups.toString()
    }

    private fun populateScoreDown() {
        row.item_comment_score_down.text = postComment.downs.toString()
    }

}
