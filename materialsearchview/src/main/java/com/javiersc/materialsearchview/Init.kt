package com.javiersc.materialsearchview

import android.content.res.TypedArray
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import com.javiersc.materialsearchview.inits.*


fun <T> MaterialSearchView<T>.init(attrs: TypedArray) {
    this.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_STABLE or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    try {
        initSearchType(attrs, this)
        initSearchTheme(attrs, this)
        initSearchText(attrs, this)
        initSearchBackground(attrs, this)
        initSearchCardsParent(attrs, this)
        initSearchCard(attrs, this)
        initSearchSuggestionCard(attrs, this)
        initSearchUpIcon(attrs, this)
        initSearchClearIcon(attrs, this)
        initSearchMicIcon(attrs, this)
        initSearchUserIcon(attrs, this)
        initRecyclerViewSuggestion(this)
    } finally {
        attrs.recycle()
    }
}