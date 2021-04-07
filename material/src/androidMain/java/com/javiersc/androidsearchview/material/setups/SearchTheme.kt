package com.javiersc.androidsearchview.material.setups

import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R
import com.javiersc.androidsearchview.material.constants.SearchTheme
import com.javiersc.androidsearchview.material.extensions.color

internal fun MaterialSearchView.setupSearchTheme(searchTheme: SearchTheme) =
    when (searchTheme) {
        SearchTheme.LIGHT -> {
            with(context) {
                searchTextColor = color(R.color.searchTextLight)
                searchTextHintColor = color(R.color.searchTextHintLight)

                searchUpIconColor = color(R.color.searchUpIconLight)

                searchCardBackgroundColor = color(R.color.searchCardBackgroundLight)

                searchSuggestionCardBackgroundColor = color(R.color.searchCardBackgroundLight)
            }
        }
        SearchTheme.DARK -> {
            with(context) {
                searchTextColor = color(R.color.searchTextDark)
                searchTextHintColor = color(R.color.searchTextHintDark)

                searchUpIconColor = color(R.color.searchUpIconDark)

                searchCardBackgroundColor = color(R.color.searchCardBackgroundDark)

                searchSuggestionCardBackgroundColor = color(R.color.searchCardBackgroundDark)
            }
        }
    }
