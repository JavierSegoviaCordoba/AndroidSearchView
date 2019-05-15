package com.javiersc.materialsearchview.setups

import android.content.Context
import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R

internal fun <T> setupSearchCardsParent(context: Context, attrs: TypedArray, msv: MaterialSearchView<T>) =
    with(attrs) {
        val searchCardsParentTranslationY: Float =
            getDimension(R.styleable.MaterialSearchView_searchCardsParentTranslationY, msv.searchCardsParentTranslationY)
        msv.searchCardsParentTranslationY = searchCardsParentTranslationY
    }
