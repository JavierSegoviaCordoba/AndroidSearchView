package com.javiersc.materialsearchview.view.menu

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

interface MenuAttrs {

    fun open(position: Int = 0)
    fun close(position: Int = 0)

    fun <T, VH : RecyclerView.ViewHolder> changeSuggestionAdapter(
        suggestionAdapter: ListAdapter<T, VH>,
        suggestionList: List<String>
    )

    fun changeSearchBackgroundColor(color: Int)
    fun changeSearchBackgroundRippleColor(color: Int)

    fun changeSearchCardBackgroundColor(color: Int)
    fun changeSearchCardCornerRadius(radius: Float)

    fun changeSearchCardUpIcon(drawable: Drawable)
    fun changeSearchCardUpIconColor(color: Int)


    fun changeSearchSuggestionCardBackgroundColor(color: Int)
    fun changeSearchSuggestionCardCornerRadius(radius: Float)
    fun changeSearchSuggestionCardVerticalOffset(offset: Float)

}