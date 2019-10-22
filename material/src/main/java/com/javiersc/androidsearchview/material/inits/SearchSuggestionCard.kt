package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R

internal fun <T> MaterialSearchView<T>.initSearchSuggestionCard(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView<T> = this
    with(attrs) {
        val searchSuggestionCardBackgroundColor: Int = getColor(
            R.styleable.MaterialSearchView_searchSuggestionCardBackgroundColor,
            materialSearchView.searchSuggestionCardBackgroundColor
        )
        materialSearchView.searchSuggestionCardBackgroundColor = searchSuggestionCardBackgroundColor

        val searchSuggestionItemMargin: Float = getDimension(
            R.styleable.MaterialSearchView_searchSuggestionItemMargin,
            materialSearchView.searchSuggestionItemMargin
        )
        materialSearchView.searchSuggestionItemMargin = searchSuggestionItemMargin

        val searchSuggestionCardCornerRadius: Float = getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardCornerRadius,
            materialSearchView.searchSuggestionCardRadius
        )
        materialSearchView.searchSuggestionCardRadius = searchSuggestionCardCornerRadius

        val searchSuggestionCardElevation: Float = getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardElevation,
            materialSearchView.searchSuggestionCardElevation
        )
        materialSearchView.searchSuggestionCardElevation = searchSuggestionCardElevation

        val searchSuggestionCardMarginLeft: Float = getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardMarginLeft,
            materialSearchView.searchSuggestionCardMarginLeft
        )
        materialSearchView.searchSuggestionCardMarginLeft = searchSuggestionCardMarginLeft

        val searchSuggestionCardMarginTop: Float = getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardMarginTop,
            materialSearchView.searchSuggestionCardMarginTop
        )
        materialSearchView.searchSuggestionCardMarginTop = searchSuggestionCardMarginTop

        val searchSuggestionCardMarginRight: Float = getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardMarginRight,
            materialSearchView.searchSuggestionCardMarginRight
        )
        materialSearchView.searchSuggestionCardMarginRight = searchSuggestionCardMarginRight

        val searchSuggestionCardMarginBottom: Float = getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardMarginBottom,
            materialSearchView.searchSuggestionCardMarginBottom
        )
        materialSearchView.searchSuggestionCardMarginBottom = searchSuggestionCardMarginBottom

        val searchSuggestionCardTranslationY: Float = getDimension(
            R.styleable.MaterialSearchView_searchSuggestionCardTranslationY,
            materialSearchView.searchSuggestionCardTranslationY
        )
        materialSearchView.searchSuggestionCardTranslationY = searchSuggestionCardTranslationY
    }
}