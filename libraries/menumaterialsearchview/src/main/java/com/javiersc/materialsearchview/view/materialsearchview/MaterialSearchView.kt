package com.javiersc.materialsearchview.view.materialsearchview

/*
import android.content.Context
import android.graphics.Typeface
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.FrameLayout
import com.javiersc.extensions.color
import com.javiersc.extensions.dimen
import com.javiersc.extensions.font
import com.javiersc.extensions.itemMargin
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.utils.keyboardMargin
import com.javiersc.materialsearchview.view.materialsearchview.utils.State
import com.javiersc.searchtext.SearchTextProperties
import com.javiersc.searchtheme.SearchThemeProperties
import com.javiersc.searchtheme.SearchTheme
import com.javiersc.suggestionlist.SuggestionListFields
import kotlinx.android.synthetic.main.search_suggestion.view.*
import kotlinx.android.synthetic.main.search_text.view.*

class MaterialSearchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), Attrs, SearchThemeProperties, SearchTextProperties,
    SuggestionListFields {

    override var searchTheme: SearchTheme = SearchTheme.LIGHT
        set(searchTheme) {
            field = searchTheme.also {
                changeSearchTheme(it)
                onSearchThemeChanged?.invoke(it)
            }
        }
    override var onSearchThemeChanged: ((theme: SearchTheme) -> Unit)? = null

    override var searchText: String = ""
        set(text) {
            field = text.also {
                changeSearchText(it)
                onSearchTextChanged?.invoke(it)
            }
        }
    override var onSearchTextChanged: ((text: String) -> Unit)? = null

    override var textSearchColor: Int = context.color(R.color.searchTextLight)
        set(color) {
            field = color.also {
                changeSearchTextColor(it)
                onSearchTextColorChanged?.invoke(it)
            }
        }
    override var onSearchTextColorChanged: ((color: Int) -> Unit)? = null

    override var searchTextHint: String = context.getString(R.string.search_label)
        set(text) {
            field = text.also {
                changeSearchTextHint(it)
                onSearchTextHintChanged?.invoke(it)
            }
        }
    override var onSearchTextHintChanged: ((text: String) -> Unit)? = null

    override var searchTextHintColor: Int = context.color(R.color.searchTextHintLight)
        set(color) {
            field = color.also {
                changeSearchTextHintColor(it)
                onSearchTextHintColorChanged?.invoke(it)
            }
        }
    override var onSearchTextHintColorChanged: ((color: Int) -> Unit)? = null

    override var searchTextFont: Typeface = context.font(R.font.montserrat_medium)
        set(typeface) {
            field = typeface.also {
                changeSearchTextFont(it)
                onSearchTextFontChanged?.invoke(it)
            }
        }
    override var onSearchTextFontChanged: ((typeface: Typeface) -> Unit)? = null

    override var onSearchSubmit: ((String?) -> Unit)? = null
    override var onKeyboardDismiss: (() -> Unit)? = null

    override var searchSuggestionItemMarginLeft: Float =
        context.dimen(R.dimen.cardViewSuggestionMarginLeft)
        set(marginLeft) {
            field = marginLeft.also {
                changeSuggestionItemMargins(
                    it,
                    searchSuggestionItemMarginTop,
                    searchSuggestionItemMarginRight,
                    searchSuggestionItemMarginBottom
                )
            }
        }
    override var searchSuggestionItemMarginTop: Float =
        context.dimen(R.dimen.cardViewSuggestionMarginTop)
        set(marginTop) {
            field = marginTop.also {
                changeSuggestionItemMargins(
                    searchSuggestionItemMarginLeft,
                    it,
                    searchSuggestionItemMarginRight,
                    searchSuggestionItemMarginBottom
                )
            }
        }
    override var searchSuggestionItemMarginRight: Float =
        context.dimen(R.dimen.cardViewSuggestionMarginRight)
        set(marginRight) {
            field = marginRight.also {
                changeSuggestionItemMargins(
                    searchSuggestionItemMarginLeft,
                    searchSuggestionItemMarginTop,
                    it,
                    searchSuggestionItemMarginBottom
                )
            }
        }
    override var searchSuggestionItemMarginBottom: Float =
        context.dimen(R.dimen.cardViewSuggestionMarginBottom)
        set(marginBottom) {
            field = marginBottom.also {
                changeSuggestionItemMargins(
                    searchSuggestionItemMarginLeft,
                    searchSuggestionItemMarginTop,
                    searchSuggestionItemMarginRight,
                    it
                )
            }

        }

    var searchFixKeyboardMargin: Float = 0f
        set(margin) {
            field = margin.also { changeFixKeyboardMargin(it) }
        }

    init {
        //@Suppress("LeakingThis")
        init(this, context, attrs)
        initSearchText(this, context, attrs)
    }


    override fun changeSearchTheme(theme: SearchTheme) = when (theme) {
        SearchTheme.LIGHT -> {
            changeSearchTextColor(context.color(R.color.searchTextLight))
            changeSearchTextHintColor(context.color(R.color.searchTextHintLight))
        }

        SearchTheme.DARK -> {
            changeSearchTextColor(context.color(R.color.searchTextDark))
            changeSearchTextHintColor(context.color(R.color.searchTextHintDark))
        }
    }

    override fun changeSearchText(text: String) = with(searchInputText) { setText(text) }
    override fun changeSearchTextColor(color: Int) = with(searchInputText) { setTextColor(color) }
    override fun changeSearchTextHint(text: String) = with(searchInputText) { hint = text }
    override fun changeSearchTextHintColor(color: Int) =
        with(searchInputText) { setHintTextColor(color) }

    override fun changeSearchTextFont(typeface: Typeface) =
        with(searchInputText) { this.typeface = typeface }


    override fun changeSearchSuggestionItemMarginLeft(left: Float) = with(recyclerViewSuggestions) {
        itemMargin(
            left,
            searchSuggestionItemMarginTop,
            searchSuggestionItemMarginRight,
            searchSuggestionItemMarginBottom
        )
    }

    override fun changeSearchSuggestionItemMarginTop(top: Float) = with(recyclerViewSuggestions) {
        itemMargin(
            searchSuggestionItemMarginLeft,
            top,
            searchSuggestionItemMarginRight,
            searchSuggestionItemMarginBottom
        )
    }

    override fun changeSearchSuggestionItemMarginRight(right: Float) =
        with(recyclerViewSuggestions) {
            itemMargin(
                searchSuggestionItemMarginLeft,
                searchSuggestionItemMarginTop,
                right,
                searchSuggestionItemMarginBottom
            )
        }

    override fun changeSearchSuggestionItemMarginBottom(bottom: Float) =
        with(recyclerViewSuggestions) {
            itemMargin(
                searchSuggestionItemMarginLeft,
                searchSuggestionItemMarginTop,
                searchSuggestionItemMarginRight,
                bottom
            )
        }

    override fun changeFixKeyboardMargin(margin: Float) {
        keyboardMargin = margin
    }

    //------------------------------------------------------------------------------------------------------------------

    override fun onSaveInstanceState(): Parcelable =
        State(super.onSaveInstanceState()).apply {
            text = this@MaterialSearchView.searchInputText.text.toString()
        }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state !is State) {
            return super.onRestoreInstanceState(state)
        }
        super.onRestoreInstanceState(state.superState)
        with(state) {
            this@MaterialSearchView.searchText = text
        }
    }
}


*/
