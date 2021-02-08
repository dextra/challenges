package dev.dextra.newsapp.components

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.core.content.ContextCompat
import dev.dextra.newsapp.R
import dev.dextra.newsapp.api.model.enums.BaseDataEnum

class CustomAutoCompleteTextView : AppCompatAutoCompleteTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun convertSelectionToString(selectedItem: Any?): CharSequence {
        if (selectedItem is BaseDataEnum) {
            return context.getString(selectedItem.getRes())
        }
        return super.convertSelectionToString(selectedItem)
    }

    override fun enoughToFilter(): Boolean {
        return true
    }

    override fun onFocusChanged(
        focused: Boolean, direction: Int,
        previouslyFocusedRect: Rect?
    ) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        if (focused) {
            performFiltering("", 0)
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
            keyListener = null
            dismissDropDown()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        performFiltering("", 0)
        showDropDown()
        return false
    }

    override fun setCompoundDrawablesWithIntrinsicBounds(
        left: Drawable?,
        top: Drawable?,
        right: Drawable?,
        bottom: Drawable?
    ) {
        var rightCopy = right
        val dropdownIcon = ContextCompat.getDrawable(context, R.drawable.arrow_drop_down)
        if (dropdownIcon != null) {
            rightCopy = dropdownIcon
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, rightCopy, bottom)

    }
}