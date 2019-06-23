package com.javiersc.materialsearchview

import android.content.res.TypedArray
import com.javiersc.materialsearchview.inits.*

fun <T> MaterialSearchView<T>.init(attrs: TypedArray) {
    try {
        initSearchType(attrs, this)
        initSearchTheme(attrs, this)
        initSearchText(attrs, this)
        initSearchBackground(attrs, this)
        initSearchCardsParent(attrs, this)
        initSearchCard(attrs, this)
        initSearchSuggestionCard(attrs, this)
        initSearchUpIcon(attrs, this)
        initRecyclerViewSuggestion(this)
    } finally {
        attrs.recycle()
    }
}