package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.constants.SearchTheme


internal fun <T> initSearchTheme(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {
    val searchTheme: Int = getInteger(R.styleable.MaterialSearchView_searchTheme, msv.searchTheme.value)
    msv.searchTheme = SearchTheme.values().find { it.value == searchTheme } ?: SearchTheme.LIGHT
}