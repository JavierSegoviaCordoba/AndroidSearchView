package com.javiersc.materialsearchview.view.materialsearchview

/*import android.content.Context
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import com.javiersc.extensions.font
import com.javiersc.materialsearchview.R
import kotlinx.android.synthetic.main.search_text.view.*


internal fun initSearchText(
    materialSearchView: MaterialSearchView,
    context: Context,
    attributeSet: AttributeSet?
) {
    val attrs = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialSearchView)
    try {
        attrs?.run {

            val searchTextColor: Int =
                getColor(
                    R.styleable.SearchText_searchTextColor,
                    materialSearchView.searchInputText.textSearchColor
                )
            materialSearchView.searchInputText.textSearchColor = searchTextColor

            val searchCardTextHint: String? =
                getString(R.styleable.SearchText_searchTextHint)
            searchCardTextHint?.let { materialSearchView.searchInputText.searchTextHint = it }

            val searchTextHintColor: Int =
                getColor(
                    R.styleable.SearchText_searchTextHintColor,
                    materialSearchView.searchInputText.searchTextHintColor
                )
            materialSearchView.searchInputText.searchTextHintColor = searchTextHintColor

            val searchTextFont: Int =
                getResourceId(R.styleable.SearchText_searchTextFont, R.font.montserrat_medium)
            materialSearchView.searchInputText.searchTextFont = context.font(searchTextFont)

            materialSearchView.searchInputText.setOnEditorActionListener { v, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    materialSearchView.onSearchSubmit?.invoke(v?.text.toString())
                }
                true
            }

        }
    } finally {
        attrs?.recycle()
    }

}*/
