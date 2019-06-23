package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import android.graphics.PointF
import android.graphics.Typeface
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.constants.SearchTextAnimation
import com.javiersc.materialsearchview.constants.SearchType
import com.javiersc.materialsearchview.extensions.font
import com.javiersc.materialsearchview.extensions.hideSoftKeyboard
import com.javiersc.materialsearchview.extensions.showSoftKeyboard
import com.javiersc.materialsearchview.setups.setupClose
import com.javiersc.materialsearchview.setups.setupOpen
import kotlinx.android.synthetic.main.material_search_view.view.*


internal val touchPoint = PointF()

internal fun <T> initSearchText(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {
    val searchText: String? = getString(R.styleable.MaterialSearchView_searchText)
    searchText?.let { msv.searchText = it }

    val searchTextColor: Int = getColor(R.styleable.MaterialSearchView_searchTextColor, msv.searchTextColor)
    msv.searchTextColor = searchTextColor

    val searchTextHint: String? = getString(R.styleable.MaterialSearchView_searchTextHint)
    searchTextHint?.let { msv.searchTextHint = it }

    val searchTextHintColor: Int =
        getColor(R.styleable.MaterialSearchView_searchTextHintColor, msv.searchTextHintColor)
    msv.searchTextHintColor = searchTextHintColor

    val searchTextFont: Int = getResourceId(R.styleable.MaterialSearchView_searchTextFont, 0)
    msv.searchTextFont = if (searchTextFont != 0) msv.context.font(searchTextFont) else Typeface.DEFAULT

    val searchTextTranslationY: Float =
        getDimension(R.styleable.MaterialSearchView_searchTextTranslationY, msv.searchTextTranslationY)
    msv.searchTextTranslationY = searchTextTranslationY

    val searchTextAnimation: SearchTextAnimation = SearchTextAnimation.values().find {
        it.value == getInt(R.styleable.MaterialSearchView_searchTextAnimation, msv.searchTextAnimation.value)
    } ?: SearchTextAnimation.TYPE
    msv.searchTextAnimation = searchTextAnimation

    val searchTextEnterDuration: Long =
        getInt(R.styleable.MaterialSearchView_searchTextEnterDuration, msv.searchTextEnterDuration.toInt()).toLong()
    msv.searchTextEnterDuration = searchTextEnterDuration

    val searchTextEnterDelay: Long =
        getInt(R.styleable.MaterialSearchView_searchTextEnterDelay, msv.searchTextEnterDelay.toInt()).toLong()
    msv.searchTextEnterDelay = searchTextEnterDelay

    val searchTextExitDuration: Long =
        getInt(R.styleable.MaterialSearchView_searchTextExitDuration, msv.searchTextExitDuration.toInt()).toLong()
    msv.searchTextExitDuration = searchTextExitDuration

    val searchTextExitDelay: Long =
        getInt(R.styleable.MaterialSearchView_searchTextExitDelay, msv.searchTextExitDelay.toInt()).toLong()
    msv.searchTextExitDelay = searchTextExitDelay

    val searchTextMarginLeft: Float =
        getDimension(R.styleable.MaterialSearchView_searchTextMarginLeft, msv.searchTextMarginLeft)
    msv.searchTextMarginLeft = searchTextMarginLeft

    val searchTextMarginTop: Float =
        getDimension(R.styleable.MaterialSearchView_searchTextMarginTop, msv.searchTextMarginTop)
    msv.searchTextMarginTop = searchTextMarginTop

    val searchTextMarginRight: Float =
        getDimension(R.styleable.MaterialSearchView_searchTextMarginRight, msv.searchTextMarginRight)
    msv.searchTextMarginRight = searchTextMarginRight

    val searchTextMarginBottom: Float =
        getDimension(R.styleable.MaterialSearchView_searchTextMarginBottom, msv.searchTextMarginBottom)
    msv.searchTextMarginBottom = searchTextMarginBottom

    msv.searchTextView.addTextChangedListener {
        msv.onSearchTextChanged?.invoke(it.toString())
        msv.onSearchSuggestionFilter?.invoke(it.toString())
    }

    msv.searchTextView.setOnEditorActionListener { v, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            msv.onSearchSubmit?.invoke(v?.text.toString())
        }
        true
    }

    msv.searchTextView.setOnTouchListener { _, event ->
        if (msv.searchType == SearchType.NORMAL) {
            touchPoint.x = event.x + msv.searchTextView.x
            touchPoint.y = event.y + msv.searchTextView.y
        }
        msv.searchTextView.requestFocus()
        false
    }

    msv.searchTextView.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
        with(msv) {
            if (hasFocus) setupOpen(this).also { showSoftKeyboard(context) }
            else setupClose(this).also { hideSoftKeyboard(context) }
        }
    }
}