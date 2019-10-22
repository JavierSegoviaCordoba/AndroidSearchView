package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R


internal fun <T> initSearchCard(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {
    val searchCardBackgroundColor: Int =
        getColor(R.styleable.MaterialSearchView_searchCardBackgroundColor, msv.searchCardBackgroundColor)
    msv.searchCardBackgroundColor = searchCardBackgroundColor

    val searchCardHeight: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardHeight, msv.searchCardHeight.toFloat())
    msv.searchCardHeight = searchCardHeight.toInt()

    val searchCardCornerRadius: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardCornerRadius, msv.searchCardRadius)
    msv.searchCardRadius = searchCardCornerRadius

    val searchCardStrokeWidth: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardStrokeWidth, msv.searchCardStrokeWidth)
    msv.searchCardStrokeWidth = searchCardStrokeWidth

    val searchCardStrokeColor: Int =
        getColor(R.styleable.MaterialSearchView_searchCardStrokeColor, msv.searchCardStrokeColor)
    msv.searchCardStrokeColor = searchCardStrokeColor

    val searchCardShadowColor: Int =
        getColor(R.styleable.MaterialSearchView_searchCardShadowColor, msv.searchCardShadowColor)
    msv.searchCardShadowColor = searchCardShadowColor

    val searchCardElevation: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardElevation, msv.searchCardElevation)
    msv.searchCardElevation = searchCardElevation

    val searchCardMarginLeft: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardMarginLeft, msv.searchCardMarginLeft)
    msv.searchCardMarginLeft = searchCardMarginLeft

    val searchCardMarginTop: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardMarginTop, msv.searchCardMarginTop)
    msv.searchCardMarginTop = searchCardMarginTop

    val searchCardMarginRight: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardMarginRight, msv.searchCardMarginRight)
    msv.searchCardMarginRight = searchCardMarginRight

    val searchCardMarginBottom: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardMarginBottom, msv.searchCardMarginBottom)
    msv.searchCardMarginBottom = searchCardMarginBottom

    val searchCardTranslationY: Float =
        getDimension(R.styleable.MaterialSearchView_searchCardTranslationY, msv.searchCardTranslationY)
    msv.searchCardTranslationY = searchCardTranslationY
}