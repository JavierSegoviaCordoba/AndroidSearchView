package com.javiersc.androidsearchview.material.setups

import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.constants.SearchTextAnimation
import com.javiersc.androidsearchview.material.extensions.addTextAnimated
import com.javiersc.androidsearchview.material.extensions.deleteTextAnimated
import com.javiersc.androidsearchview.material.extensions.fadeIn
import com.javiersc.androidsearchview.material.extensions.fadeOut
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> MaterialSearchView<T>.clearSearchText() {
    searchTextView.text?.let { editable ->
        val total =
            searchTextEnterDuration + searchTextEnterDelay + searchTextExitDuration + searchTextExitDelay
        if (editable.isNotEmpty()) {
            val tempText = onSearchTextChanged
            val tempFilter = onSearchSuggestionFilter
            onSearchTextChanged = null
            onSearchSuggestionFilter = null
            searchSuggestionAdapter?.submitList(emptyList())
            when (searchTextAnimation) {
                SearchTextAnimation.TYPE -> {
                    searchTextView.deleteTextAnimated(
                        searchTextEnterDuration,
                        searchTextEnterDelay
                    )
                    searchTextView.addTextAnimated(
                        searchTextHint,
                        searchTextExitDuration,
                        searchTextExitDelay
                    )
                    postDelayed({
                        onSearchTextChanged = tempText
                        onSearchSuggestionFilter = tempFilter
                    }, total)
                }
                SearchTextAnimation.FADE -> {
                    searchTextView.fadeOut(searchTextEnterDuration, searchTextEnterDelay)
                    searchTextView.fadeIn(searchTextExitDuration, searchTextExitDelay)
                    postDelayed({
                        onSearchTextChanged = tempText
                        onSearchSuggestionFilter = tempFilter
                    }, total)
                }
                SearchTextAnimation.NONE -> {
                    searchTextView.setText("")
                    postDelayed({
                        onSearchTextChanged = tempText
                        onSearchSuggestionFilter = tempFilter
                    }, 0)
                }
            }
        }
    }
}