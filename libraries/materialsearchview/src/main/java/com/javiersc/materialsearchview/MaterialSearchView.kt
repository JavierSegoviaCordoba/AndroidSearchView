package com.javiersc.materialsearchview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.extensions.*
import com.javiersc.materialsearchview.setups.setupClose
import com.javiersc.materialsearchview.setups.setupOpen
import com.javiersc.materialsearchview.utils.SearchBackgroundAnimation
import com.javiersc.materialsearchview.utils.SearchBehavior
import com.javiersc.searchtext.SearchTextAnimation
import com.javiersc.searchtext.SearchTextProperties
import com.javiersc.searchtheme.SearchTheme
import com.javiersc.searchtheme.SearchThemeProperties
import com.javiersc.suggestionlist.SuggestionListFields
import kotlinx.android.synthetic.main.material_search_view.view.*


class MaterialSearchView<T> @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr), SearchThemeProperties, SearchTextProperties,
    SuggestionListFields<T>, MaterialSearchViewProperties, CoordinatorLayout.AttachedBehavior {


    // THEME
    override var searchTheme: SearchTheme = SearchTheme.LIGHT
        set(value) {
            field = value.also {
                changeSearchTheme(it)
                onSearchThemeChanged?.invoke(it)
            }
        }
    override var onSearchThemeChanged: ((searchTheme: SearchTheme) -> Unit)? = null

    override fun changeSearchTheme(searchTheme: SearchTheme) = when (searchTheme) {
        SearchTheme.LIGHT -> {
            with(context) {
                searchTextView.setTextColor(color(R.color.searchTextLight))
            }
        }
        SearchTheme.DARK -> {
            with(context) {
                searchTextView.setTextColor(color(R.color.searchTextDark))
            }
        }
    }

    // TEXT
    override var searchText: String = ""
        set(value) {
            field = value.also {
                searchTextView.setText(it)
                onSearchTextChanged?.invoke(it)
                onSearchSuggestionFilter?.invoke(it)
            }
        }
    override var onSearchTextChanged: ((text: String) -> Unit)? = null

    override var searchTextColor: Int = context.color(R.color.searchTextLight)
        set(value) {
            field = value.also { searchTextView.setTextColor(it) }
        }

    override var searchTextHint: String = context.getString(R.string.search_label)
        set(value) {
            field = value.also { searchTextView.hint = it }
        }

    override var searchTextHintColor: Int = context.color(R.color.searchTextHintLight)
        set(value) {
            field = value.also { searchTextView.setHintTextColor(it) }
        }

    override var searchTextFont: Typeface = context.font(R.font.roboto_medium)
        set(value) {
            field = value.also { searchTextView.typeface = it }
        }

    override var searchTextTranslationY: Float = 0f
        set(value) {
            field = value.also { searchTextView.translationY = it }
        }
    override var searchTextAnimation: SearchTextAnimation = SearchTextAnimation.TYPE
    override var searchTextEnterDuration: Long = 350
    override var searchTextEnterDelay: Long = 0
    override var searchTextExitDuration: Long = 350
    override var searchTextExitDelay: Long = 350

    override var searchTextMarginLeft: Float = context.dimen(R.dimen.searchCardTextMarginLeft)
        set(value) {
            field = value.also { searchTextView.marginLeft(it.toInt()) }
        }
    override var searchTextMarginTop: Float = context.dimen(R.dimen.searchCardTextMarginRight)
        set(value) {
            field = value.also { searchTextView.marginTop(it.toInt()) }
        }
    override var searchTextMarginRight: Float = 0f
        set(value) {
            field = value.also { searchTextView.marginRight(it.toInt()) }
        }
    override var searchTextMarginBottom: Float = 0f
        set(value) {
            field = value.also { searchTextView.marginBottom(it.toInt()) }
        }
    override var onSearchSubmit: ((String?) -> Unit)? = null
    override var onKeyboardDismiss: (() -> Unit)? = null

    //BACKGROUND
    override var searchBackgroundColor: Int = context.color(R.color.searchBackgroundLight)
        set(value) {
            field = value.also { cardViewBackground.setCardBackgroundColor(it) }
        }
    override var searchBackgroundRippleColor: Int =
        context.color(R.color.searchBackgroundRippleLight)
        set(value) {
            field = value.also { cardViewBackground.rippleColor = it.colorStateList() }
        }
    override var searchBackgroundOpenDuration: Long = 500
    override var searchBackgroundOpenDelay: Long = 0
    override var searchBackgroundCloseDuration: Long = 500
    override var searchBackgroundCloseDelay: Long = 0
    override var searchBackgroundAnimation: SearchBackgroundAnimation = SearchBackgroundAnimation.FADE

    //CARDS PARENT
    override var searchCardsParentTranslationY: Float = 0f
        set(value) {
            field = value.also { constrainLayoutParent.translationY = it }
        }

    //CARD BACKGROUND
    override var searchCardBackgroundColor: Int = context.color(R.color.searchCardBackgroundLight)
        set(value) {
            field = value.also { cardViewSearch.setCardBackgroundColor(it) }
        }

    override var searchCardCornerRadius: Float = context.dimen(R.dimen.cardViewSearchCornerRadius)
        set(value) {
            field = value.also { cardViewSearch.radius = it }
        }

    override var searchCardElevation: Float = context.dimen(R.dimen.cardViewSearchElevation)
        set(value) {
            field = value.also { cardViewSearch.cardElevation = it }
        }

    //ICON
    override var searchUpIcon: Drawable = DrawerArrowDrawable(context)
        set(value) {
            field = value.also { imageButtonUp.setImageDrawable(it) }
        }
    override var searchUpIconDuration: Long = 300
    override var searchUpIconDelay: Long = 0
    override var onSearchUpIconListener: (() -> Unit)? = null

    override var searchSuggestionAdapter: ListAdapter<in T, RecyclerView.ViewHolder>? = null
        set(value) {
            field = value
            recyclerViewSuggestionList.apply {
                itemPadding(16.dp())
                layoutManager = LinearLayoutManager(context)
                adapter = value
            }
        }
    override var onSearchSuggestionFilter: ((text: String) -> Unit)? = null

    //OPEN-CLOSE
    override var isOpen: Boolean = false

    override fun open() = setupOpen(this)
    override fun close() = setupClose(this)

    override fun getBehavior(): CoordinatorLayout.Behavior<*> = SearchBehavior<T>(context)

    init {

        View.inflate(context, R.layout.material_search_view, this@MaterialSearchView)

        val attrs: TypedArray =
            context.obtainStyledAttributes(attributeSet, R.styleable.MaterialSearchView)

        init(context, attrs, this)

    }
}
