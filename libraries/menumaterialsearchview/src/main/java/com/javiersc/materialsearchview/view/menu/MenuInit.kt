package com.javiersc.materialsearchview.view.menu
/*

import android.content.Context
import android.util.AttributeSet
import com.javiersc.materialsearchview.R
import com.javiersc.extensions.color
import com.javiersc.extensions.dimen
import com.javiersc.materialsearchview.view.materialsearchview.selectedTheme

//todo check if delete
var upDrawableDefined = false

internal class MenuInit(
    private val menuMaterialSearchView: MenuMaterialSearchView,
    private val context: Context,
    attrSet: AttributeSet?
) {

    init {
        val attrs = context.obtainStyledAttributes(attrSet, R.styleable.MenuMaterialSearchView)
        try {
            attrs?.run {


                val cardBackgroundColor =
                    getColor(R.styleable.MenuMaterialSearchView_backgroundColor, MenuDefaultValues.colorBackground)
                setSearchBackgroundColor(cardBackgroundColor)

                val cardBackgroundRippleColor =
                    getColor(
                        R.styleable.MenuMaterialSearchView_BackgroundRippleColor,
                        MenuDefaultValues.colorBackgroundRipple
                    )
                setSearchBackgroundRippleColor(cardBackgroundRippleColor)


                val searchCardBackgroundColor =
                    getColor(
                        R.styleable.MenuMaterialSearchView_searchCardBackgroundColor,
                        MenuDefaultValues.colorSearchCardBackground
                    )
                setSearchCardBackgroundColor(searchCardBackgroundColor)

                val searchCardCornerRadius = getDimension(
                    R.styleable.MenuMaterialSearchView_searchCardCornerRadius,
                    context.dimen(R.dimen.cardViewSearchCornerRadius)
                )
                setSearchCardCornerRadius(searchCardCornerRadius)

                val searchCardUpIcon = getDrawable(R.styleable.MenuMaterialSearchView_searchCardUpIcon)
                searchCardUpIcon?.let { setSearchCardUpIcon(searchCardUpIcon) }

                val searchCardUpIconColor = getColor(
                    R.styleable.MenuMaterialSearchView_searchCardUpIconColor,
                    context.color(R.color.searchUpIconLight)
                )
                setSearchCardUpIconColor(searchCardUpIconColor)

                val suggestionCardBackgroundColor = getColor(
                    R.styleable.MenuMaterialSearchView_suggestionCardBackgroundColor,
                    searchCardBackgroundColor
                )
                setSuggestionCardBackgroundColor(suggestionCardBackgroundColor)

                val suggestionCardOffset =
                    attrs.getDimension(
                        R.styleable.MenuMaterialSearchView_suggestionCardVerticalOffset,
                        context.dimen(R.dimen.cardViewSuggestionVerticalOffset)
                    )
                setSuggestionCardVerticalOffset(suggestionCardOffset)

                val suggestionCardCornerRadius =
                    getDimension(R.styleable.MenuMaterialSearchView_suggestionCardCornerRadius, searchCardCornerRadius)
                setSuggestionCardCornerRadius(suggestionCardCornerRadius)

            }
        } finally {
            attrs?.recycle()
        }

    }
}*/
