package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R

internal fun <T> MaterialSearchView<T>.initSearchCardsParent(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView<T> = this
    with(attrs) {
        val searchCardsParentTranslationY: Float = getDimension(
            R.styleable.MaterialSearchView_searchCardsParentTranslationY,
            materialSearchView.searchCardsParentTranslationY
        )
        materialSearchView.searchCardsParentTranslationY = searchCardsParentTranslationY
    }
}
