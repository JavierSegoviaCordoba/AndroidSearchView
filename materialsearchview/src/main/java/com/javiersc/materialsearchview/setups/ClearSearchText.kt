package com.javiersc.materialsearchview.setups

import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.constants.SearchTextAnimation
import com.javiersc.materialsearchview.extensions.addTextAnimated
import com.javiersc.materialsearchview.extensions.deleteTextAnimated
import com.javiersc.materialsearchview.extensions.fadeIn
import com.javiersc.materialsearchview.extensions.fadeOut
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> MaterialSearchView<T>.clearSearchText() {
    searchTextView.text?.let { editable ->
        val total = searchTextEnterDuration + searchTextEnterDelay + searchTextExitDuration + searchTextExitDelay
        if (editable.isNotEmpty()) {
            val tempText = onSearchTextChanged
            val tempFilter = onSearchSuggestionFilter
            onSearchTextChanged = null
            onSearchSuggestionFilter = null
            searchSuggestionAdapter?.submitList(emptyList())
            when (searchTextAnimation) {
                SearchTextAnimation.TYPE -> {
                    searchTextView.deleteTextAnimated(searchTextEnterDuration, searchTextEnterDelay)
                    searchTextView.addTextAnimated(searchTextHint, searchTextExitDuration, searchTextExitDelay)
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