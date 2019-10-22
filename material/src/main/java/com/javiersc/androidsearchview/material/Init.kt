package com.javiersc.androidsearchview.material

import android.content.res.TypedArray
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import com.javiersc.androidsearchview.material.inits.*


fun <T> MaterialSearchView<T>.init(attrs: TypedArray) {
    this.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_STABLE or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    try {
        initSearchType(attrs)
        initSearchTheme(attrs)
        initSearchText(attrs)
        initSearchBackground(attrs)
        initSearchCardsParent(attrs)
        initSearchCard(attrs)
        initSearchSuggestionCard(attrs)
        initSearchUpIcon(attrs)
        initSearchClearIcon(attrs)
        initSearchMicIcon(attrs)
        initSearchUserIcon(attrs)
        initRecyclerViewSuggestion()
    } finally {
        attrs.recycle()
    }
}