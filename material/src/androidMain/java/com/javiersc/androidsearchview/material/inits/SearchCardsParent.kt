package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R

internal fun MaterialSearchView.initSearchCardsParent(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView = this
    with(attrs) {
        val searchCardsParentTranslationY: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardsParentTranslationY,
                materialSearchView.searchCardsParentTranslationY
            )
        materialSearchView.searchCardsParentTranslationY = searchCardsParentTranslationY
    }
}
