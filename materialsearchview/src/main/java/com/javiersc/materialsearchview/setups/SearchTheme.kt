package com.javiersc.materialsearchview.setups

import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.constants.SearchTheme
import com.javiersc.materialsearchview.extensions.color


internal fun <T> MaterialSearchView<T>.setupSearchTheme(searchTheme: SearchTheme) = when (searchTheme) {
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