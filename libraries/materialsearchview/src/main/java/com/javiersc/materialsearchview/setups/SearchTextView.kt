package com.javiersc.materialsearchview.setups

import android.content.Context
import android.content.res.TypedArray
import android.graphics.PointF
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import com.javiersc.extensions.font
import com.javiersc.extensions.hideSoftKeyboard
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.searchtext.SearchTextAnimation
import kotlinx.android.synthetic.main.material_search_view.view.*

internal val touchPoint = PointF()

internal fun <T> setupSearchTextView(context: Context, attrs: TypedArray, msv: MaterialSearchView<T>) =
    with(attrs) {
        val searchTextColor: Int = getColor(R.styleable.MaterialSearchView_searchTextColor, msv.searchTextColor)
        msv.searchTextColor = searchTextColor

        val searchCardTextHint: String? = attrs.getString(R.styleable.MaterialSearchView_searchTextHint)
        searchCardTextHint?.let { msv.searchTextHint = it }

        val searchTextHintColor: Int =
            getColor(R.styleable.MaterialSearchView_searchTextHintColor, msv.searchTextHintColor)
        msv.searchTextHintColor = searchTextHintColor

        val searchTextFont: Int =
            attrs.getResourceId(R.styleable.MaterialSearchView_searchTextFont, R.font.roboto_medium)
        msv.searchTextFont = context.font(searchTextFont)

        val searchTextTranslationY: Float =
            attrs.getDimension(R.styleable.MaterialSearchView_searchTextTranslationY, msv.searchTextTranslationY)
        msv.searchTextTranslationY = searchTextTranslationY

        val searchTextAnimation: SearchTextAnimation = SearchTextAnimation.values().find {
            it.value == attrs.getInt(
                R.styleable.MaterialSearchView_searchTextAnimation,
                msv.searchTextAnimation.value
            )
        } ?: SearchTextAnimation.TYPE
        msv.searchTextAnimation = searchTextAnimation

        val searchTextEnterDuration: Long =
            attrs.getInt(R.styleable.MaterialSearchView_searchTextEnterDuration, msv.searchTextEnterDuration.toInt())
                .toLong()
        msv.searchTextEnterDuration = searchTextEnterDuration

        val searchTextEnterDelay: Long =
            attrs.getInt(R.styleable.MaterialSearchView_searchTextEnterDelay, msv.searchTextEnterDelay.toInt()).toLong()
        msv.searchTextEnterDelay = searchTextEnterDelay

        val searchTextExitDuration: Long =
            attrs.getInt(R.styleable.MaterialSearchView_searchTextExitDuration, msv.searchTextExitDuration.toInt())
                .toLong()
        msv.searchTextExitDuration = searchTextExitDuration

        val searchTextExitDelay: Long =
            attrs.getInt(R.styleable.MaterialSearchView_searchTextExitDelay, msv.searchTextExitDelay.toInt()).toLong()
        msv.searchTextExitDelay = searchTextExitDelay

        val searchTextMarginLeft: Float =
            attrs.getDimension(R.styleable.MaterialSearchView_searchTextMarginLeft, msv.searchTextMarginLeft)
        msv.searchTextMarginLeft = searchTextMarginLeft

        val searchTextMarginTop: Float =
            attrs.getDimension(R.styleable.MaterialSearchView_searchTextMarginTop, msv.searchTextMarginTop)
        msv.searchTextMarginTop = searchTextMarginTop

        val searchTextMarginRight: Float =
            attrs.getDimension(R.styleable.MaterialSearchView_searchTextMarginRight, msv.searchTextMarginRight)
        msv.searchTextMarginRight = searchTextMarginRight

        val searchTextMarginBottom: Float =
            attrs.getDimension(R.styleable.MaterialSearchView_searchTextMarginBottom, msv.searchTextMarginBottom)
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

        msv.searchTextView.setOnTouchListener { v, event ->
            touchPoint.x = event.x + msv.searchTextView.x
            touchPoint.y = event.y + msv.searchTextView.y
            msv.searchTextView.requestFocus()
            false
        }

        msv.searchTextView.setOnFocusChangeListener { v, hasFocus ->
            with(msv) { if (hasFocus) open() else close().also { if (isOpen) hideSoftKeyboard(context) } }
        }
    }