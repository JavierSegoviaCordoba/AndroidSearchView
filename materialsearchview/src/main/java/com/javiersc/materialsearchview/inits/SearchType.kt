package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.constants.SearchType


internal fun <T> initSearchType(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {
    val searchType: Int = getInteger(R.styleable.MaterialSearchView_searchType, msv.searchType.value)
    msv.searchType = SearchType.values().find { it.value == searchType } ?: SearchType.NORMAL
}