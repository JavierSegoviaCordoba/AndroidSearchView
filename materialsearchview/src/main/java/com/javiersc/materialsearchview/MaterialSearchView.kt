package com.javiersc.materialsearchview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.javiersc.materialsearchview.constants.SearchBackgroundAnimation
import com.javiersc.materialsearchview.constants.SearchTextAnimation
import com.javiersc.materialsearchview.constants.SearchTheme
import com.javiersc.materialsearchview.constants.SearchType
import com.javiersc.materialsearchview.extensions.*
import com.javiersc.materialsearchview.setups.setupSearchTheme
import com.javiersc.materialsearchview.utils.SearchBehavior
import kotlinx.android.synthetic.main.material_search_view.view.*


class MaterialSearchView<T> @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr), CoordinatorLayout.AttachedBehavior {

    //SEARCH TYPE
    var searchType: SearchType = SearchType.NORMAL
        set(value) {
            field = value.also {
                when (it) {
                    SearchType.NORMAL -> cardViewSearch.visible()
                    SearchType.MENU -> cardViewSearch.invisible()
                }
            }
        }
    var searchMenuItem: MenuItem? = null

    // THEME
    var searchTheme: SearchTheme = SearchTheme.LIGHT
        set(value) {
            field = value.also { setupSearchTheme(it) }
        }


    // TEXT
    var searchText: String = context.getString(R.string.search)
        set(value) {
            field = value.also {
                searchTextView.setText(it)
                onSearchTextChanged?.invoke(it)
                onSearchSuggestionFilter?.invoke(it)
            }
        }
    var onSearchTextChanged: ((text: String) -> Unit)? = null

    var searchTextColor: Int = context.color(R.color.searchTextLight)
        set(value) {
            field = value.also { searchTextView.setTextColor(it) }
        }
    var searchTextHint: String = context.getString(R.string.search_hint)
        set(value) {
            field = value.also { searchTextView.hint = it }
        }
    var searchTextHintColor: Int = context.color(R.color.searchTextHintLight)
        set(value) {
            field = value.also { searchTextView.setHintTextColor(it) }
        }
    var searchTextFont: Typeface = Typeface.DEFAULT
        set(value) {
            field = value.also { searchTextView.typeface = it }
        }
    var searchTextMarginLeft: Float = context.dimen(R.dimen.searchTextMarginLeft)
        set(value) {
            field = value.also { searchTextView.marginLeft(it.toInt()) }
        }
    var searchTextMarginTop: Float = context.dimen(R.dimen.searchTextMarginTop)
        set(value) {
            field = value.also { searchTextView.marginTop(it.toInt()) }
        }
    var searchTextMarginRight: Float = context.dimen(R.dimen.searchTextMarginRight)
        set(value) {
            field = value.also { searchTextView.marginRight(it.toInt()) }
        }
    var searchTextMarginBottom: Float = context.dimen(R.dimen.searchTextMarginBottom)
        set(value) {
            field = value.also { searchTextView.marginBottom(it.toInt()) }
        }
    var searchTextTranslationY: Float = context.dimen(R.dimen.searchTextTranslationY)
        set(value) {
            field = value.also { searchTextView.translationY = it }
        }
    var searchTextAnimation: SearchTextAnimation = SearchTextAnimation.TYPE
    var searchTextEnterDuration: Long = context.int(R.integer.searchTextEnterDuration).toLong()
    var searchTextEnterDelay: Long = context.int(R.integer.searchTextEnterDelay).toLong()
    var searchTextExitDuration: Long = context.int(R.integer.searchTextExitDuration).toLong()
    var searchTextExitDelay: Long = context.int(R.integer.searchTextExitDelay).toLong()

    var onSearchSubmit: ((String?) -> Unit)? = null
    var onKeyboardDismiss: (() -> Unit)? = null

    //BACKGROUND
    var searchBackgroundColor: Int = context.color(R.color.searchBackgroundLight)
        set(value) {
            field = value.also { cardViewBackground.setCardBackgroundColor(it) }
        }
    var searchBackgroundRippleColor: Int = context.color(R.color.searchBackgroundRippleLight)
        set(value) {
            field = value.also { cardViewBackground.rippleColor = it.colorStateList() }
        }
    var searchBackgroundOpenDuration: Long = context.int(R.integer.searchBackgroundOpenDuration).toLong()
    var searchBackgroundOpenDelay: Long = context.int(R.integer.searchBackgroundOpenDelay).toLong()
    var searchBackgroundCloseDuration: Long = context.int(R.integer.searchBackgroundCloseDuration).toLong()
    var searchBackgroundCloseDelay: Long = context.int(R.integer.searchBackgroundCloseDelay).toLong()

    var searchBackgroundAnimation: SearchBackgroundAnimation = SearchBackgroundAnimation.FADE

    //CARDS PARENT
    var searchCardsParentTranslationY: Float = context.dimen(R.dimen.searchCardsParentTranslationY)
        set(value) {
            field = value.also { constrainLayoutParent.translationY = it }
        }

    //CARD SEARCH
    var searchCardBackgroundColor: Int = context.color(R.color.searchCardBackgroundLight)
        set(value) {
            field = value.also { cardViewSearch.setCardBackgroundColor(it) }
        }
    var searchCardCornerRadius: Float = context.dimen(R.dimen.cardViewSearchCornerRadius)
        set(value) {
            field = value.also { cardViewSearch.radius = it }
        }
    var searchCardElevation: Float = context.dimen(R.dimen.cardViewSearchElevation)
        set(value) {
            field = value.also { cardViewSearch.cardElevation = it }
        }
    var searchCardMarginLeft: Float = context.dimen(R.dimen.searchCardMarginLeft)
        set(value) {
            field = value.also { cardViewSearch.marginLeft(it.toInt()) }
        }
    var searchCardMarginTop: Float = context.dimen(R.dimen.searchCardMarginTop)
        set(value) {
            field = value.also { cardViewSearch.marginTop(it.toInt()) }
        }
    var searchCardMarginRight: Float = context.dimen(R.dimen.searchCardMarginRight)
        set(value) {
            field = value.also { cardViewSearch.marginRight(it.toInt()) }
        }
    var searchCardMarginBottom: Float = context.dimen(R.dimen.searchCardMarginBottom)
        set(value) {
            field = value.also { cardViewSearch.marginBottom(it.toInt()) }
        }
    var searchCardTranslationY: Float = context.dimen(R.dimen.searchCardTranslationY)
        set(value) {
            field = value.also { cardViewSearch.translationY = it }
        }


    //ICON
    var searchUpIcon: Drawable? = null
        set(value) {
            field = value.also { imageButtonUp.setImageDrawable(it) }
        }
    var searchUpIconColor: Int = context.color(R.color.searchUpIconLight)
        set(value) {
            field = value.also { imageButtonUp.setColorFilter(it) }
        }
    var searchUpIconMarginLeft: Float = context.dimen(R.dimen.searchUpIconMarginLeft)
        set(value) {
            field = value.also { imageButtonUp.marginLeft(it.toInt()) }
        }
    var searchUpIconDuration: Long = context.int(R.integer.searchUpIconDuration).toLong()
    var searchUpIconDelay: Long = context.int(R.integer.searchUpIconDelay).toLong()
    var onSearchUpIconListener: (() -> Unit)? = null

    // SUGGESTION
    var searchSuggestionCardBackgroundColor: Int = context.color(R.color.searchCardBackgroundLight)
        set(value) {
            field = value.also { cardViewSuggestion.setCardBackgroundColor(it) }
        }
    var searchSuggestionAdapter: ListAdapter<*, *>? = null
        set(value) {
            field = value
            recyclerViewSuggestionList.apply {
                itemPadding(searchSuggestionItemMargin.toInt())
                layoutManager = LinearLayoutManager(context)
                adapter = value
            }
        }
    var searchSuggestionItemMargin: Float = context.dimen(R.dimen.searchSuggestionItemMargin)

    var searchSuggestionCardMarginLeft: Float = context.dimen(R.dimen.searchSuggestionCardMarginLeft)
        set(value) {
            field = value.also { cardViewSuggestion.marginLeft(it.toInt()) }
        }
    var searchSuggestionCardMarginTop: Float = context.dimen(R.dimen.searchSuggestionCardMarginTop)
        set(value) {
            field = value.also { cardViewSuggestion.marginTop(it.toInt()) }
        }
    var searchSuggestionCardMarginRight: Float = context.dimen(R.dimen.searchSuggestionCardMarginRight)
        set(value) {
            field = value.also { cardViewSuggestion.marginRight(it.toInt()) }
        }
    var searchSuggestionCardMarginBottom: Float = context.dimen(R.dimen.searchSuggestionCardMarginBottom)
        set(value) {
            field = value.also { cardViewSuggestion.marginBottom(it.toInt()) }
        }
    var searchSuggestionCardElevation: Float = context.dimen(R.dimen.searchSuggestionCardElevation)
        set(value) {
            field = value.also { cardViewSuggestion.elevation = it }
        }
    var searchSuggestionCardRadius: Float = context.dimen(R.dimen.searchSuggestionCardRadius)
        set(value) {
            field = value.also { cardViewSuggestion.radius = it }
        }
    var searchSuggestionCardTranslationY: Float = context.dimen(R.dimen.searchSuggestionCardTranslationY)
        set(value) {
            field = value.also { cardViewSuggestion.translationY = it }
        }

    var onSearchSuggestionFilter: ((text: String) -> Unit)? = null

    //OPEN-CLOSE
    var isOpen: Boolean = false

    fun open(): Unit = with(searchTextView) { requestFocus() }
    fun close(): Unit = with(searchTextView) { clearFocus() }

    override fun getBehavior(): CoordinatorLayout.Behavior<*> = SearchBehavior<T>(context)

    init {

        inflate(context, R.layout.material_search_view, this)

        val attrs: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialSearchView)

        init(attrs)

    }

}
