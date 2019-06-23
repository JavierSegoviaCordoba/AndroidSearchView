package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.extensions.drawable
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> initSearchUpIcon(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {

    val searchUpIcon: Int = getResourceId(R.styleable.MaterialSearchView_searchUpIcon, 0)
    msv.searchUpIcon = if (searchUpIcon != 0) msv.context.drawable(searchUpIcon) else null

    val searchUpIconColor: Int = getColor(R.styleable.MaterialSearchView_searchUpIconColor, msv.searchUpIconColor)
    msv.searchUpIconColor = searchUpIconColor

    val searchUpIconDuration: Long =
        getInteger(R.styleable.MaterialSearchView_searchUpIconDuration, msv.searchUpIconDuration.toInt()).toLong()
    msv.searchUpIconDuration = searchUpIconDuration

    val searchCardMarginLeft: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardMarginLeft, msv.searchCardMarginLeft)
    msv.searchCardMarginLeft = searchCardMarginLeft

    val searchUpIconMarginLeft: Float =
        getDimension(R.styleable.MaterialSearchView_searchUpIconMarginLeft, msv.searchUpIconMarginLeft)
    msv.searchUpIconMarginLeft = searchUpIconMarginLeft

    with(msv) {
        imageButtonUp.apply {
            setImageDrawable(DrawerArrowDrawable(context))
            setOnClickListener {
                if (isOpen) searchTextView.clearFocus()
                onSearchUpIconListener?.invoke()
            }
        }
    }
}