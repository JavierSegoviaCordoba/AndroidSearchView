package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R


internal fun <T> initSearchSuggestionCard(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {
    val searchSuggestionCardBackgroundColor: Int =
        getColor(
            R.styleable.MaterialSearchView_searchSuggestionCardBackgroundColor,
            msv.searchSuggestionCardBackgroundColor
        )
    msv.searchSuggestionCardBackgroundColor = searchSuggestionCardBackgroundColor

    val searchSuggestionItemMargin: Float =
        getDimension(R.styleable.MaterialSearchView_searchSuggestionItemMargin, msv.searchSuggestionItemMargin)
    msv.searchSuggestionItemMargin = searchSuggestionItemMargin

    val searchSuggestionCardCornerRadius: Float =
        getDimension(R.styleable.MaterialSearchView_searchSuggestionCardCornerRadius, msv.searchSuggestionCardRadius)
    msv.searchSuggestionCardRadius = searchSuggestionCardCornerRadius

    val searchSuggestionCardElevation: Float =
        getDimension(R.styleable.MaterialSearchView_searchSuggestionCardElevation, msv.searchSuggestionCardElevation)
    msv.searchSuggestionCardElevation = searchSuggestionCardElevation

    val searchSuggestionCardMarginLeft: Float =
        getDimension(R.styleable.MaterialSearchView_searchSuggestionCardMarginLeft, msv.searchSuggestionCardMarginLeft)
    msv.searchSuggestionCardMarginLeft = searchSuggestionCardMarginLeft

    val searchSuggestionCardMarginTop: Float =
        getDimension(R.styleable.MaterialSearchView_searchSuggestionCardMarginTop, msv.searchSuggestionCardMarginTop)
    msv.searchSuggestionCardMarginTop = searchSuggestionCardMarginTop

    val searchSuggestionCardMarginRight: Float =
        getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardMarginRight,
            msv.searchSuggestionCardMarginRight
        )
    msv.searchSuggestionCardMarginRight = searchSuggestionCardMarginRight

    val searchSuggestionCardMarginBottom: Float =
        getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardMarginBottom,
            msv.searchSuggestionCardMarginBottom
        )
    msv.searchSuggestionCardMarginBottom = searchSuggestionCardMarginBottom

    val searchSuggestionCardTranslationY: Float =
        getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardTranslationY,
            msv.searchSuggestionCardTranslationY
        )
    msv.searchSuggestionCardTranslationY = searchSuggestionCardTranslationY
}