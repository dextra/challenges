package com.fastnews.mechanism

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import com.fastnews.R

class FontTextView : TextView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setFont(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        setFont(context, attrs)
    }

    private fun setFont(context: Context, attrs: AttributeSet) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.FontTextView, 0, 0)
        var font = typedArray.getString(R.styleable.FontTextView_textFont)
        typedArray.recycle()

        if (TextUtils.isEmpty(font)) {
            font = DEFAULT_FONT
        }

        try {
            val tf = Typeface.createFromAsset(context.assets, font)
            typeface = tf
        } catch (e: RuntimeException) {
            Log.e(TAG, "Font path not found: " + font!!, e)
        }

    }

    companion object {

        private val TAG = FontTextView::class.java.simpleName
        private val DEFAULT_FONT = "fonts/Roboto/Roboto-Regular.ttf"
    }
}