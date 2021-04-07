package com.javiersc.androidsearchview.material

import android.content.res.TypedArray
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import com.javiersc.androidsearchview.material.inits.initRecyclerViewSuggestion
import com.javiersc.androidsearchview.material.inits.initSearchBackground
import com.javiersc.androidsearchview.material.inits.initSearchCard
import com.javiersc.androidsearchview.material.inits.initSearchCardsParent
import com.javiersc.androidsearchview.material.inits.initSearchClearIcon
import com.javiersc.androidsearchview.material.inits.initSearchMicIcon
import com.javiersc.androidsearchview.material.inits.initSearchSuggestionCard
import com.javiersc.androidsearchview.material.inits.initSearchText
import com.javiersc.androidsearchview.material.inits.initSearchTheme
import com.javiersc.androidsearchview.material.inits.initSearchType
import com.javiersc.androidsearchview.material.inits.initSearchUpIcon
import com.javiersc.androidsearchview.material.inits.initSearchUserIcon

fun MaterialSearchView.init(attrs: TypedArray) {
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
