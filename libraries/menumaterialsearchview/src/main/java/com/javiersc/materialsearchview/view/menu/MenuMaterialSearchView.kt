package com.javiersc.materialsearchview.view.menu
/*

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.materialsearchview.R
import com.javiersc.extensions.color
import com.javiersc.extensions.colorStateList
import com.javiersc.extensions.dimen
import com.javiersc.materialsearchview.view.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.view.materialsearchview.setups.SuggestionAdapter
import com.javiersc.materialsearchview.view.materialsearchview.setups.setupRecyclerViewSuggestion
import com.javiersc.materialsearchview.view.materialsearchview.setups.setupTextInputEditText
import com.javiersc.materialsearchview.view.materialsearchview.utils.SearchTheme
import com.javiersc.materialsearchview.view.menu.setups.*
import com.javiersc.materialsearchview.view.menu.utils.MenuState
import kotlinx.android.synthetic.main.menu_msv.view.*
import kotlinx.android.synthetic.main.component_search_text.view.*
import kotlin.properties.Delegates.observable


class MenuMaterialSearchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialSearchView(context, attrs, defStyleAttr), MenuAttrs {

    init {

        inflate(context, R.layout.menu_msv, this@MenuMaterialSearchView)

        MenuInit(this, context, attrs)

        setupTextInputEditText(this)
        setupCardViewSearch(this)
        setupCardViewBackground(this)

    }

    var isOpen: Boolean by observable(false) { _, _, newValue ->
        onOpenCloseChange?.invoke(newValue)
    }
    var onOpenCloseChange: ((isOpen: Boolean) -> Unit)? = null

    var adapter: SuggestionAdapter<Any, RecyclerView.ViewHolder>? = null
        set(adapter) {
            field = adapter
            adapter?.let { setupRecyclerViewSuggestion(this, it.suggestionAdapter, it.suggestionList) }
        }

    var searchBackgroundColor: Int = context.color(R.color.searchBackgroundLight)
        set(searchBackgroundColor) {
            field = searchBackgroundColor.also {
                changeSearchBackgroundColor(it)
                onSearchBackgroundColorChanged?.invoke(it)
            }
        }
    var onSearchBackgroundColorChanged: ((color: Int) -> Unit)? = null

    var searchBackgroundRippleColor: Int = context.color(R.color.searchBackgroundRippleLight)
        set(searchBackgroundRippleColor) {
            field = searchBackgroundRippleColor.also {
                changeSearchBackgroundRippleColor(it)
                onSearchBackgroundRippleColorChanged?.invoke(it)
            }
        }
    var onSearchBackgroundRippleColorChanged: ((color: Int) -> Unit)? = null

    var searchCardBackgroundColor: Int = context.color(R.color.searchCardBackgroundLight)
        set(searchCardBackgroundColor) {
            field = searchCardBackgroundColor.also {
                changeSearchCardBackgroundColor(it)
                onSearchCardBackgroundColorChanged?.invoke(it)
            }
        }
    var onSearchCardBackgroundColorChanged: ((color: Int) -> Unit)? = null

    var searchCardCornerRadius: Float = context.dimen(R.dimen.cardViewSearchCornerRadius)
        set(searchCardCornerRadius) {
            field = searchCardCornerRadius.also {
                changeSearchCardCornerRadius(it)
                onSearchCardCornerRadius?.invoke(it)
            }
        }
    var onSearchCardCornerRadius: ((radius: Float) -> Unit)? = null

    var searchCardUpIcon: Drawable? = DrawerArrowDrawable(context)
        set(searchCardUpIcon) {
            field = searchCardUpIcon?.also {
                changeSearchCardUpIcon(it)
                onSearchCardUpIcon?.invoke(it)
            }
        }
    var onSearchCardUpIcon: ((icon: Drawable) -> Unit)? = null

    var searchSuggestionCardBackgroundColor: Int = context.color(R.color.suggestionCardBackgroundLight)
        set(searchSuggestionCardBackgroundColor) {
            field = searchSuggestionCardBackgroundColor.also {
                changeSearchSuggestionCardBackgroundColor(searchSuggestionCardBackgroundColor)
                onSearchSuggestionCardBackgroundColor?.invoke(searchSuggestionCardBackgroundColor)
            }
        }
    var onSearchSuggestionCardBackgroundColor: ((color: Int) -> Unit)? = null

    var searchSuggestionCardCornerRadius: Float = context.dimen(R.dimen.cardViewSuggestionCornerRadius)
        set(searchSuggestionCardCornerRadius) {
            field = searchSuggestionCardCornerRadius.also {
                changeSearchSuggestionCardCornerRadius(it)
                onSearchSuggestionCardCornerRadius?.invoke(it)
            }
        }
    var onSearchSuggestionCardCornerRadius: ((radius: Float) -> Unit)? = null

    var searchSuggestionCardVerticalOffset: Float = context.dimen(R.dimen.cardViewSuggestionVerticalOffset)
        set(searchSuggestionCardVerticalOffset) {
            field = searchSuggestionCardVerticalOffset.also {
                changeSearchSuggestionCardVerticalOffset(it)
                onSearchSuggestionCardVerticalOffset?.invoke(it)
            }
        }
    var onSearchSuggestionCardVerticalOffset: ((offset: Float) -> Unit)? = null

    override fun open(position: Int) = openMenuMSV(this, position)

    override fun close(position: Int) = closeMenuMSV(this, position)

    override fun <T, VH : RecyclerView.ViewHolder> changeSuggestionAdapter(
        suggestionAdapter: ListAdapter<T, VH>,
        suggestionList: List<String>
    ) = setupRecyclerViewSuggestion(
        this,
        suggestionAdapter,
        suggestionList
    )

    override fun changeSearchTheme(searchTheme: SearchTheme) {
        super.changeSearchTheme(searchTheme)

    }

    override fun changeSearchBackgroundColor(color: Int) =
        with(this.cardViewBackground) { setCardBackgroundColor(color) }

    override fun changeSearchBackgroundRippleColor(color: Int) =
        with(this.cardViewBackground) { rippleColor = color.colorStateList() }

    override fun changeSearchCardBackgroundColor(color: Int) =
        with(this.cardViewSearch) { setCardBackgroundColor(color) }

    override fun changeSearchCardCornerRadius(radius: Float) = with(this.cardViewSearch) { this.radius = radius }


    override fun changeSearchCardUpIcon(drawable: Drawable) =
        with(this) { imageButtonUp.setImageDrawable(drawable) }

    override fun changeSearchCardUpIconColor(color: Int) = with(this.imageButtonUp) { setColorFilter(color) }


    override fun changeSearchSuggestionCardBackgroundColor(color: Int) =
        with(this.cardViewSuggestion) { setCardBackgroundColor(color) }

    override fun changeSearchSuggestionCardVerticalOffset(offset: Float) = with(this.cardViewSuggestion) {
        translationY = offset
        fixTranslationY = offset.toInt()
    }

    override fun changeSearchSuggestionCardCornerRadius(radius: Float) =
        with(this.cardViewSuggestion) { this.radius = radius }


    //------------------------------------------------------------------------------------------------------------------

    override fun onSaveInstanceState(): Parcelable =
        MenuState(super.onSaveInstanceState()).apply {
            isOpen = this@MenuMaterialSearchView.isOpen
            searchText = this@MenuMaterialSearchView.searchText
        }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state !is MenuState) return super.onRestoreInstanceState(state)
        else super.onRestoreInstanceState(state.superState)

        setupRestoreInstanceState(state, this)
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        if (hasWindowFocus && isOpen) this.textInputEditText.requestFocus()
        if (!hasWindowFocus) this.textInputEditText.clearFocus()
        super.onWindowFocusChanged(hasWindowFocus)
    }
}

*/
