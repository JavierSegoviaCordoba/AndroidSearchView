package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R
import com.javiersc.androidsearchview.material.constants.SearchTheme

internal fun MaterialSearchView.initSearchTheme(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView = this
    with(attrs) {
        val searchTheme: Int =
            getInteger(
                R.styleable.MaterialSearchView_searchTheme,
                materialSearchView.searchTheme.value
            )
        materialSearchView.searchTheme =
            SearchTheme.values().find { theme: SearchTheme -> theme.value == searchTheme }
                ?: SearchTheme.LIGHT
    }
}
