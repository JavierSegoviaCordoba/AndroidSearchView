package com.javiersc.materialsearchview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.extensions.*
import com.javiersc.materialsearchview.setups.setupClose
import com.javiersc.materialsearchview.setups.setupOpen
import com.javiersc.materialsearchview.utils.SearchBackgroundAnimation
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
    SuggestionListFields<T>, MaterialSearchViewProperties {


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

    override var searchTextFont: Typeface = context.font(R.font.montserrat_medium)
        set(value) {
            field = value.also { searchTextView.typeface = it }
        }

    override var searchTextAnimation: SearchTextAnimation = SearchTextAnimation.FADE
    override var searchTextEnterDuration: Long = 350
    override var searchTextEnterDelay: Long = 0
    override var searchTextExitDuration: Long = 350
    override var searchTextExitDelay: Long = 350

    override var onSearchSubmit: ((String?) -> Unit)? = null
    override var onKeyboardDismiss: (() -> Unit)? = null

    // BACKGROUND
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
    override var searchCardBackgroundAnimation: SearchBackgroundAnimation = SearchBackgroundAnimation.FADE

    //CARD BACKGROUND
    override var searchCardBackgroundColor: Int = context.color(R.color.searchCardBackgroundLight)
        set(value) {
            field = value.also { cardViewSearch.setCardBackgroundColor(it) }
        }

    override var searchCardCornerRadius: Float = context.dimen(R.dimen.cardViewSearchCornerRadius)
        set(value) {
            field = value.also { cardViewSearch.radius = it }
        }

    //ICON
    override var searchUpIcon: Drawable = DrawerArrowDrawable(context)
        set(value) {
            field = value.also { imageButtonUp.setImageDrawable(it) }
        }
    override var searchUpIconDuration: Long = 300
    override var searchUpIconDelay: Long = 0
    override var onSearchUpIconListener: (() -> Unit)? = null

    override var searchSuggestionAdapter: ListAdapter<out T, RecyclerView.ViewHolder>? = null
        set(value) {
            field = value
            recyclerViewSuggestionList.apply {
                itemPadding(16.dp())
                layoutManager = LinearLayoutManager(context)
                adapter = value
            }
        }

    //OPEN-CLOSE
    override var isOpen: Boolean = false

    override fun open() = setupOpen(this)
    override fun close() = setupClose(this)

    init {

        View.inflate(context, R.layout.material_search_view, this@MaterialSearchView)

        val attrs: TypedArray =
            context.obtainStyledAttributes(attributeSet, R.styleable.MaterialSearchView)

        init(context, attrs, this)

    }
}
