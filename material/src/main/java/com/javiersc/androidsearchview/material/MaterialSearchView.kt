package com.javiersc.androidsearchview.material

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.javiersc.androidsearchview.material.constants.SearchBackgroundAnimation
import com.javiersc.androidsearchview.material.constants.SearchTextAnimation
import com.javiersc.androidsearchview.material.constants.SearchTheme
import com.javiersc.androidsearchview.material.constants.SearchType
import com.javiersc.androidsearchview.material.extensions.*
import com.javiersc.androidsearchview.material.setups.setupSearchTheme
import com.javiersc.androidsearchview.material.utils.SearchBehavior
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
                    SearchType.MATERIALDESIGN2 -> cardViewSearch.invisible() //TODO
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
                searchTextView.setSelection(it.length)
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
    var searchTextFont: Typeface = context.font(R.font.google_sans_regular)
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
    var searchBackgroundOpenDuration: Long =
        context.int(R.integer.searchBackgroundOpenDuration).toLong()
    var searchBackgroundOpenDelay: Long = context.int(R.integer.searchBackgroundOpenDelay).toLong()
    var searchBackgroundCloseDuration: Long =
        context.int(R.integer.searchBackgroundCloseDuration).toLong()
    var searchBackgroundCloseDelay: Long =
        context.int(R.integer.searchBackgroundCloseDelay).toLong()

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
    var searchCardRadius: Float = context.dimen(R.dimen.searchCardRadius)
        set(value) {
            field = value.also { cardViewSearch.radius = it }
        }
    var searchCardElevation: Float = context.dimen(R.dimen.searchCardElevation)
        set(value) {
            field = value.also { cardViewSearch.cardElevation = it }
        }
    @RequiresApi(28)
    var searchCardShadowColor: Int = Color.TRANSPARENT
        set(value) {
            field = value.also {
                if (Build.VERSION.SDK_INT >= 28) {
                    cardViewSearch.outlineAmbientShadowColor = it
                    cardViewSearch.outlineSpotShadowColor = it
                }
            }
        }
    var searchCardStrokeWidth: Float = context.dimen(R.dimen.searchCardStrokeWidth)
        set(value) {
            field = value.also { cardViewSearch.strokeWidth = it.toInt() }
        }
    var searchCardStrokeColor: Int = Color.TRANSPARENT
        set(value) {
            field = value.also { cardViewSearch.strokeColor = it }
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
    var searchCardHeight: Int =
        context.actionBarHeight() - searchCardMarginTop.toInt() - searchCardMarginBottom.toInt()
        set(value) {
            field = value.also { cardViewSearch.setHeight(it) }
        }
    var searchCardTranslationY: Float = context.dimen(R.dimen.searchCardTranslationY)
        set(value) {
            field = value.also { cardViewSearch.translationY = it }
        }


    //ICONS
    var searchUpIcon: Drawable? = DrawerArrowDrawable(context).apply { alpha = 255 }
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

    var searchClearIconEnabled: Boolean = false
        set(value) {
            field = value.also {
                if (it) imageButtonClear.visible() else imageButtonClear.gone()
            }
        }
    var searchClearIcon: Drawable? = context.drawable(R.drawable.ic_clear)
        set(value) {
            field = value.also { imageButtonClear.setImageDrawable(it) }
        }
    var searchClearIconColor: Int = context.color(R.color.searchUpIconLight)
        set(value) {
            field = value.also { imageButtonClear.setColorFilter(it) }
        }
    var onSearchClearIconListener: (() -> Unit)? = null

    var searchMicIconEnabled: Boolean = false
        set(value) {
            field = value.also {
                if (it) imageButtonMic.visible() else imageButtonMic.gone()
            }
        }
    var searchMicIcon: Drawable? = context.drawable(R.drawable.ic_mic)
        set(value) {
            field = value.also { imageButtonMic.setImageDrawable(it) }
        }
    var searchMicIconColor: Int = context.color(R.color.searchUpIconLight)
        set(value) {
            field = value.also { imageButtonMic.setColorFilter(it) }
        }
    var onSearchMicIconListener: (() -> Unit)? = null

    var searchUserIconEnabled: Boolean = false
        set(value) {
            field = value.also {
                if (it) cardViewUser.visible() else cardViewUser.gone()
            }
        }
    var searchUserIcon: Drawable? = context.drawable(R.drawable.ic_mic)
        set(value) {
            field = value.also { imageButtonUser.setImageDrawable(it) }
        }
    var searchUserIconColor: Int = Color.TRANSPARENT
        set(value) {
            field = value.also { imageButtonUser.setColorFilter(it) }
        }
    var searchUserIconBorderWidth: Float = 0f
        set(value) {
            field = value.also { cardViewUser.strokeWidth = it.toInt() }
        }
    var searchUserIconBorderColor: Int = Color.TRANSPARENT
        set(value) {
            field = value.also { cardViewUser.strokeColor = it }
        }
    var onSearchUserIconListener: (() -> Unit)? = null

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

    var searchSuggestionCardMarginLeft: Float =
        context.dimen(R.dimen.searchSuggestionCardMarginLeft)
        set(value) {
            field = value.also { cardViewSuggestion.marginLeft(it.toInt()) }
        }
    var searchSuggestionCardMarginTop: Float = context.dimen(R.dimen.searchSuggestionCardMarginTop)
        set(value) {
            field = value.also { cardViewSuggestion.marginTop(it.toInt()) }
        }
    var searchSuggestionCardMarginRight: Float =
        context.dimen(R.dimen.searchSuggestionCardMarginRight)
        set(value) {
            field = value.also { cardViewSuggestion.marginRight(it.toInt()) }
        }
    var searchSuggestionCardMarginBottom: Float =
        context.dimen(R.dimen.searchSuggestionCardMarginBottom)
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
    var searchSuggestionCardTranslationY: Float =
        context.dimen(R.dimen.searchSuggestionCardTranslationY)
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

        val attrs: TypedArray = context.obtainStyledAttributes(
            attributeSet, R.styleable.MaterialSearchView
        )

        init(attrs)
    }
}

