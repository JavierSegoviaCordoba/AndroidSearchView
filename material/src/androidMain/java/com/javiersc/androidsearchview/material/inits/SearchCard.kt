package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R

internal fun MaterialSearchView.initSearchCard(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView = this
    with(attrs) {
        val searchCardBackgroundColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchCardBackgroundColor,
                materialSearchView.searchCardBackgroundColor
            )
        materialSearchView.searchCardBackgroundColor = searchCardBackgroundColor

        val searchCardHeight: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardHeight,
                searchCardHeight.toFloat()
            )
        materialSearchView.searchCardHeight = searchCardHeight.toInt()

        val searchCardCornerRadius: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardCornerRadius,
                materialSearchView.searchCardRadius
            )
        materialSearchView.searchCardRadius = searchCardCornerRadius

        val searchCardStrokeWidth: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardStrokeWidth,
                materialSearchView.searchCardStrokeWidth
            )
        materialSearchView.searchCardStrokeWidth = searchCardStrokeWidth

        val searchCardStrokeColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchCardStrokeColor,
                materialSearchView.searchCardStrokeColor
            )
        materialSearchView.searchCardStrokeColor = searchCardStrokeColor

        val searchCardShadowColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchCardShadowColor,
                materialSearchView.searchCardShadowColor
            )
        materialSearchView.searchCardShadowColor = searchCardShadowColor

        val searchCardElevation: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardElevation,
                materialSearchView.searchCardElevation
            )
        materialSearchView.searchCardElevation = searchCardElevation

        val searchCardMarginLeft: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardMarginLeft,
                materialSearchView.searchCardMarginLeft
            )
        materialSearchView.searchCardMarginLeft = searchCardMarginLeft

        val searchCardMarginTop: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardMarginTop,
                materialSearchView.searchCardMarginTop
            )
        materialSearchView.searchCardMarginTop = searchCardMarginTop

        val searchCardMarginRight: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardMarginRight,
                materialSearchView.searchCardMarginRight
            )
        materialSearchView.searchCardMarginRight = searchCardMarginRight

        val searchCardMarginBottom: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardMarginBottom,
                materialSearchView.searchCardMarginBottom
            )
        materialSearchView.searchCardMarginBottom = searchCardMarginBottom

        val searchCardTranslationY: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchCardTranslationY,
                materialSearchView.searchCardTranslationY
            )
        materialSearchView.searchCardTranslationY = searchCardTranslationY
    }
}
