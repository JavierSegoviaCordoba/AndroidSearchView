package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.extensions.drawable
import com.javiersc.materialsearchview.setups.clearSearchText
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> initSearchClearIcon(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {

    val searchClearIconEnabled: Boolean =
        getBoolean(R.styleable.MaterialSearchView_searchClearIconEnabled, msv.searchClearIconEnabled)
    msv.searchClearIconEnabled = searchClearIconEnabled

    val searchClearIcon: Int = getResourceId(R.styleable.MaterialSearchView_searchClearIcon, 0)
    if (searchClearIcon != 0) msv.context.drawable(searchClearIcon)?.let { msv.searchClearIcon = it }
    else msv.searchClearIcon = msv.searchClearIcon

    val searchClearIconColor: Int =
        getColor(R.styleable.MaterialSearchView_searchClearIconColor, msv.searchClearIconColor)
    msv.searchClearIconColor = searchClearIconColor

    msv.imageButtonClear.setOnClickListener {
        msv.clearSearchText()
        msv.onSearchClearIconListener?.invoke()
    }

}