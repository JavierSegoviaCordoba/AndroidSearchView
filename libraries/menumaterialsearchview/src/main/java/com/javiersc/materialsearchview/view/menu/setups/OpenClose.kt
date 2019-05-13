package com.javiersc.materialsearchview.view.menu.setups
/*

import android.os.Handler
import com.javiersc.materialsearchview.utils.Coords
import com.javiersc.materialsearchview.utils.upAnimation
import com.javiersc.materialsearchview.view.menu.MenuMaterialSearchView
import kotlinx.android.synthetic.main.menu_msv.view.*
import kotlinx.android.synthetic.main.component_search_text.view.*

internal fun openMenuMSV(menuMaterialSearchView: MenuMaterialSearchView, position: Int) = with(menuMaterialSearchView) {
    if (!cardViewSearch.isVisible || !cardViewBackground.isVisible) {
        val searchCoords = Coords.searchCard(position, cardViewSearch)
        val backgroundCoords = Coords.backgroundCard(position, cardViewSearch)

        cardViewSearch.show(searchCoords.x, searchCoords.y, duration = 500)
        cardViewBackground.show(backgroundCoords.x, backgroundCoords.y, duration = 450, isBackground = true)
        cardViewSuggestion.visible()
        cardViewBackground.isClickable = true

        upAnimation(context, this, delay = 250)

        textInputEditText.requestFocus()
        isOpen = true
    }
}

internal fun closeMenuMSV(menuMaterialSearchView: MenuMaterialSearchView, position: Int) =
    with(menuMaterialSearchView) {
        if (cardViewSearch.isVisible || cardViewBackground.isVisible) {
            val searchCoords = Coords.searchCard(position, cardViewSearch)
            val backgroundCoords = Coords.backgroundCard(position, cardViewSearch)

            cardViewSearch.hide(searchCoords.x, searchCoords.y, duration = 500)
            cardViewBackground.hide(backgroundCoords.x, backgroundCoords.y, duration = 550, isBackground = true)
            cardViewSuggestion.hide(searchCoords.x, 0f, duration = 350)
            cardViewBackground.isClickable = false

            //todo improve this
            val handler = Handler()
            handler.postDelayed({
                textInputEditText.text?.clear()
                this.adapter?.suggestionAdapter?.submitList(listOf())
            }, 1000)

            upAnimation(context, this, delay = 0, inverse = true)

            textInputEditText.clearFocus()
            isOpen = false
        }
    }*/
