package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import android.graphics.PointF
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R
import com.javiersc.androidsearchview.material.constants.SearchTextAnimation
import com.javiersc.androidsearchview.material.constants.SearchType
import com.javiersc.androidsearchview.material.extensions.font
import com.javiersc.androidsearchview.material.extensions.hideSoftKeyboard
import com.javiersc.androidsearchview.material.extensions.showSoftKeyboard
import com.javiersc.androidsearchview.material.setups.setupClose
import com.javiersc.androidsearchview.material.setups.setupOpen
import kotlinx.android.synthetic.main.material_search_view.view.searchTextView

internal val touchPoint = PointF()

internal fun MaterialSearchView.initSearchText(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView = this
    with(attrs) {
        val searchText: String? = getString(R.styleable.MaterialSearchView_searchText)
        searchText?.let { materialSearchView.searchText = it }

        val searchTextColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchTextColor,
                materialSearchView.searchTextColor
            )
        materialSearchView.searchTextColor = searchTextColor

        val searchTextHint: String? = getString(R.styleable.MaterialSearchView_searchTextHint)
        searchTextHint?.let { materialSearchView.searchTextHint = it }

        val searchTextHintColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchTextHintColor,
                materialSearchView.searchTextHintColor
            )
        materialSearchView.searchTextHintColor = searchTextHintColor

        val searchTextFont: Int = getResourceId(R.styleable.MaterialSearchView_searchTextFont, 0)
        materialSearchView.searchTextFont =
            if (searchTextFont != 0) materialSearchView.context.font(searchTextFont)
            else materialSearchView.searchTextFont

        val searchTextTranslationY: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchTextTranslationY,
                materialSearchView.searchTextTranslationY
            )
        materialSearchView.searchTextTranslationY = searchTextTranslationY

        val searchTextAnimation: SearchTextAnimation =
            SearchTextAnimation.values().find {
                it.value ==
                    getInt(
                        R.styleable.MaterialSearchView_searchTextAnimation,
                        materialSearchView.searchTextAnimation.value
                    )
            }
                ?: SearchTextAnimation.TYPE
        materialSearchView.searchTextAnimation = searchTextAnimation

        val searchTextEnterDuration: Long =
            getInt(
                    R.styleable.MaterialSearchView_searchTextEnterDuration,
                    materialSearchView.searchTextEnterDuration.toInt()
                )
                .toLong()
        materialSearchView.searchTextEnterDuration = searchTextEnterDuration

        val searchTextEnterDelay: Long =
            getInt(
                    R.styleable.MaterialSearchView_searchTextEnterDelay,
                    materialSearchView.searchTextEnterDelay.toInt()
                )
                .toLong()
        materialSearchView.searchTextEnterDelay = searchTextEnterDelay

        val searchTextExitDuration: Long =
            getInt(
                    R.styleable.MaterialSearchView_searchTextExitDuration,
                    materialSearchView.searchTextExitDuration.toInt()
                )
                .toLong()
        materialSearchView.searchTextExitDuration = searchTextExitDuration

        val searchTextExitDelay: Long =
            getInt(
                    R.styleable.MaterialSearchView_searchTextExitDelay,
                    materialSearchView.searchTextExitDelay.toInt()
                )
                .toLong()
        materialSearchView.searchTextExitDelay = searchTextExitDelay

        val searchTextMarginLeft: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchTextMarginLeft,
                materialSearchView.searchTextMarginLeft
            )
        materialSearchView.searchTextMarginLeft = searchTextMarginLeft

        val searchTextMarginTop: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchTextMarginTop,
                materialSearchView.searchTextMarginTop
            )
        materialSearchView.searchTextMarginTop = searchTextMarginTop

        val searchTextMarginRight: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchTextMarginRight,
                materialSearchView.searchTextMarginRight
            )
        materialSearchView.searchTextMarginRight = searchTextMarginRight

        val searchTextMarginBottom: Float =
            getDimension(
                R.styleable.MaterialSearchView_searchTextMarginBottom,
                materialSearchView.searchTextMarginBottom
            )
        materialSearchView.searchTextMarginBottom = searchTextMarginBottom

        searchTextView.addTextChangedListener { editable ->
            materialSearchView.onSearchTextChanged?.invoke(editable.toString())
            materialSearchView.onSearchSuggestionFilter?.invoke(editable.toString())
        }

        searchTextView.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                materialSearchView.onSearchSubmit?.invoke(v?.text.toString())
            }
            true
        }

        searchTextView.setOnTouchListener { _, event ->
            if (materialSearchView.searchType == SearchType.NORMAL) {
                touchPoint.x = event.x + searchTextView.x
                touchPoint.y = event.y + searchTextView.y
            }
            searchTextView.requestFocus()
            false
        }

        searchTextView.onFocusChangeListener =
            View.OnFocusChangeListener { _, hasFocus ->
                with(materialSearchView) {
                    if (hasFocus) materialSearchView.setupOpen().also { showSoftKeyboard(context) }
                    else materialSearchView.setupClose().also { hideSoftKeyboard(context) }
                }
            }
    }
}
