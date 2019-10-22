package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.extensions.drawable
import kotlinx.android.synthetic.main.material_search_view.view.*


internal fun <T> initSearchUserIcon(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {

    val searchUserIconEnabled: Boolean =
        getBoolean(R.styleable.MaterialSearchView_searchUserIconEnabled, msv.searchUserIconEnabled)
    msv.searchUserIconEnabled = searchUserIconEnabled

    val searchUserIcon: Int = getResourceId(R.styleable.MaterialSearchView_searchUserIcon, 0)
    if (searchUserIcon != 0) msv.context.drawable(searchUserIcon)?.let { msv.searchUserIcon = it }
    else msv.searchUserIcon = msv.searchUserIcon

    val searchUserIconColor: Int =
        getColor(R.styleable.MaterialSearchView_searchUserIconColor, msv.searchUserIconColor)
    msv.searchUserIconColor = searchUserIconColor

    val searchUserIconBorderColor: Int =
        getColor(R.styleable.MaterialSearchView_searchUserIconBorderColor, msv.searchUserIconBorderColor)
    msv.searchUserIconBorderColor = searchUserIconBorderColor

    val searchUserIconBorderWidth: Float =
        getDimension(R.styleable.MaterialSearchView_searchUserIconBorderWidth, msv.searchUserIconBorderWidth)
    msv.searchUserIconBorderWidth = searchUserIconBorderWidth

    msv.imageButtonUser.setOnClickListener { msv.onSearchUserIconListener?.invoke() }

}