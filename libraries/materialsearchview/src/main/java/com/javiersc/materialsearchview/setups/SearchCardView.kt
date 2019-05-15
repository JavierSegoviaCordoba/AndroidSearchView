package com.javiersc.materialsearchview.setups

import android.content.Context
import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R


internal fun <T> setupSearchCardView(context: Context, attrs: TypedArray, msv: MaterialSearchView<T>) =
    with(attrs) {
        val searchCardBackgroundColor: Int =
            getColor(R.styleable.MaterialSearchView_searchCardBackgroundColor, msv.searchCardBackgroundColor)
        msv.searchCardBackgroundColor = searchCardBackgroundColor

        val searchCardCornerRadius: Float =
            getDimension(R.styleable.MaterialSearchView_searchCardCornerRadius, msv.searchCardCornerRadius)
        msv.searchCardCornerRadius = searchCardCornerRadius

        val searchCardElevation: Float =
            getDimension(R.styleable.MaterialSearchView_searchCardElevation, msv.searchCardElevation)
        msv.searchCardElevation = searchCardElevation
    }