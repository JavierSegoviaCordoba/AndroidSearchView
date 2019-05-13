package com.javiersc.materialsearchview.view.materialsearchview

/*
import android.content.Context
import android.util.AttributeSet
import com.javiersc.materialsearchview.R
import com.javiersc.extensions.font
import com.javiersc.materialsearchview.view.materialsearchview.utils.SearchTheme

internal fun init(
    materialSearchView: MaterialSearchView,
    context: Context,
    attrSet: AttributeSet?
) {

        val attrs = context.obtainStyledAttributes(attrSet, R.styleable.MaterialSearchView)
        try {
            attrs?.run {
                val searchTheme: Int =
                    getInteger(R.styleable.MaterialSearchView_searchTheme, materialSearchView.searchTheme.value)
                val theme: SearchTheme? = SearchTheme.values().find { theme -> theme.value == searchTheme }
                theme?.let { materialSearchView.searchTheme = it }

                val searchCardTextColor: Int =
                    getColor(R.styleable.MaterialSearchView_searchTextColor, materialSearchView.textSearchColor)
                materialSearchView.textSearchColor = searchCardTextColor

                val searchCardTextHint: String? = getString(R.styleable.MaterialSearchView_searchTextHint)
                searchCardTextHint?.let { materialSearchView.searchTextHint = it }

                val searchCardTextHintColor: Int =
                    getColor(R.styleable.MaterialSearchView_searchTextHintColor, materialSearchView.searchTextHintColor)
                materialSearchView.searchTextHintColor = searchCardTextHintColor

                val searchCardTextFont: Int = getResourceId(
                    R.styleable.MaterialSearchView_searchTextFont, R.font.montserrat_medium
                )
                materialSearchView.searchTextFont = context.font(searchCardTextFont)

                val itemMarginLeft = getDimension(
                    R.styleable.MaterialSearchView_suggestionItemMarginLeft,
                    materialSearchView.searchSuggestionMarginLeft
                )
                materialSearchView.searchSuggestionMarginLeft = itemMarginLeft

                val itemMarginTop = getDimension(
                    R.styleable.MaterialSearchView_suggestionItemMarginTop,
                    materialSearchView.searchSuggestionMarginTop
                )
                materialSearchView.searchSuggestionMarginTop = itemMarginTop

                val itemMarginRight = getDimension(
                    R.styleable.MaterialSearchView_suggestionItemMarginRight,
                    materialSearchView.searchSuggestionMarginRight
                )
                materialSearchView.searchSuggestionMarginRight = itemMarginRight

                val itemMarginBottom = getDimension(
                    R.styleable.MaterialSearchView_suggestionItemMarginBottom,
                    materialSearchView.searchSuggestionMarginBottom
                )
                materialSearchView.searchSuggestionMarginBottom = itemMarginBottom

                val fixKeyboardMargin = getDimension(
                    R.styleable.MaterialSearchView_fixKeyboardMargin,
                    materialSearchView.searchFixKeyboardMargin
                )
                materialSearchView.searchFixKeyboardMargin = fixKeyboardMargin
            }
        } finally {
            attrs?.recycle()
        }

    }
}*/
