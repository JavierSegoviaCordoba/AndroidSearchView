package com.javiersc.materialsearchview

import android.content.Context
import android.content.res.TypedArray
import com.javiersc.materialsearchview.setups.*

fun <T> init(context: Context, attrs: TypedArray, materialSearchView: MaterialSearchView<T>) {
    try {
        setupSearchTextView(context, attrs, materialSearchView)
        setupSearchCardView(context, attrs, materialSearchView)
        setupSearchImageButtonUp(context, attrs, materialSearchView)
        setupCardViewBackground(context, attrs, materialSearchView)
        setupRecyclerViewSuggestion(context, attrs, materialSearchView)
    } finally {
        attrs.recycle()
    }
}