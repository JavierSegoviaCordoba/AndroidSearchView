package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R
import com.javiersc.androidsearchview.material.extensions.drawable
import kotlinx.android.synthetic.main.material_search_view.view.imageButtonUser

internal fun MaterialSearchView.initSearchUserIcon(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView = this
    with(attrs) {
        val searchUserIconEnabled: Boolean =
            getBoolean(
                R.styleable.MaterialSearchView_searchUserIconEnabled,
                materialSearchView.searchUserIconEnabled
            )
        materialSearchView.searchUserIconEnabled = searchUserIconEnabled

        val searchUserIcon: Int = getResourceId(R.styleable.MaterialSearchView_searchUserIcon, 0)
        if (searchUserIcon != 0)
            materialSearchView.context.drawable(searchUserIcon)?.let { icon ->
                materialSearchView.searchUserIcon = icon
            }
        else materialSearchView.searchUserIcon = materialSearchView.searchUserIcon

        val searchUserIconColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchUserIconColor,
                materialSearchView.searchUserIconColor
            )
        materialSearchView.searchUserIconColor = searchUserIconColor

        val searchUserIconBorderColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchUserIconBorderColor,
                materialSearchView.searchUserIconBorderColor
            )
        materialSearchView.searchUserIconBorderColor = searchUserIconBorderColor

        val searchUserIconBorderWidth: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchUserIconBorderWidth,
                materialSearchView.searchUserIconBorderWidth
            )
        materialSearchView.searchUserIconBorderWidth = searchUserIconBorderWidth

        imageButtonUser.setOnClickListener { materialSearchView.onSearchUserIconListener?.invoke() }
    }
}
