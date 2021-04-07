package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R
import com.javiersc.androidsearchview.material.extensions.drawable
import com.javiersc.androidsearchview.material.setups.clearSearchText
import kotlinx.android.synthetic.main.material_search_view.view.imageButtonClear

internal fun MaterialSearchView.initSearchClearIcon(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView = this
    with(attrs) {
        val searchClearIconEnabled: Boolean =
            getBoolean(
                R.styleable.MaterialSearchView_searchClearIconEnabled,
                materialSearchView.searchClearIconEnabled
            )
        materialSearchView.searchClearIconEnabled = searchClearIconEnabled

        val searchClearIcon: Int = getResourceId(R.styleable.MaterialSearchView_searchClearIcon, 0)
        if (searchClearIcon != 0)
            materialSearchView.context.drawable(searchClearIcon)?.let {
                materialSearchView.searchClearIcon = it
            }
        else materialSearchView.searchClearIcon = materialSearchView.searchClearIcon

        val searchClearIconColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchClearIconColor,
                materialSearchView.searchClearIconColor
            )
        materialSearchView.searchClearIconColor = searchClearIconColor

        imageButtonClear.setOnClickListener {
            materialSearchView.clearSearchText()
            materialSearchView.onSearchClearIconListener?.invoke()
        }
    }
}
