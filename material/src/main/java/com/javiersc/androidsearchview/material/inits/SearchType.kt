package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R
import com.javiersc.androidsearchview.material.constants.SearchType

internal fun <T> MaterialSearchView<T>.initSearchType(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView<T> = this
    with(attrs) {
        val searchType: Int = getInteger(
            R.styleable.MaterialSearchView_searchType,
            materialSearchView.searchType.value
        )
        materialSearchView.searchType = SearchType.values()
            .find { type: SearchType -> type.value == searchType }
            ?: SearchType.NORMAL
    }
}