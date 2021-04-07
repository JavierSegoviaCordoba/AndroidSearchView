package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R
import com.javiersc.androidsearchview.material.extensions.drawable
import kotlinx.android.synthetic.main.material_search_view.view.imageButtonUp

internal fun MaterialSearchView.initSearchUpIcon(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView = this
    with(attrs) {
        val searchUpIcon: Int = getResourceId(R.styleable.MaterialSearchView_searchUpIcon, 0)
        if (searchUpIcon != 0)
            materialSearchView.context.drawable(searchUpIcon)?.let {
                materialSearchView.searchUpIcon = it
            }
        else materialSearchView.searchUpIcon = materialSearchView.searchUpIcon

        val searchUpIconColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchUpIconColor,
                materialSearchView.searchUpIconColor
            )
        materialSearchView.searchUpIconColor = searchUpIconColor

        val searchUpIconDuration: Long =
            getInteger(
                    R.styleable.MaterialSearchView_searchUpIconDuration,
                    materialSearchView.searchUpIconDuration.toInt()
                )
                .toLong()
        materialSearchView.searchUpIconDuration = searchUpIconDuration

        val searchCardMarginLeft: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardMarginLeft,
                materialSearchView.searchCardMarginLeft
            )
        materialSearchView.searchCardMarginLeft = searchCardMarginLeft

        val searchUpIconMarginLeft: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchUpIconMarginLeft,
                materialSearchView.searchUpIconMarginLeft
            )
        materialSearchView.searchUpIconMarginLeft = searchUpIconMarginLeft

        imageButtonUp.setOnClickListener {
            if (materialSearchView.isOpen) materialSearchView.close()
            else materialSearchView.onSearchUpIconListener?.invoke()
        }
    }
}
