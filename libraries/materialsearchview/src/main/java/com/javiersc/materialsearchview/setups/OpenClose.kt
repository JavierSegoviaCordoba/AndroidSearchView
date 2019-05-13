package com.javiersc.materialsearchview.setups

import android.app.Activity
import android.view.WindowManager
import com.javiersc.extensions.*
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.extensions.drawerArrow
import com.javiersc.materialsearchview.utils.SearchBackgroundAnimation
import com.javiersc.searchtext.SearchTextAnimation
import kotlinx.android.synthetic.main.material_search_view.view.*


fun <T> setupOpen(msv: MaterialSearchView<T>) = with(msv) {
    if (context is Activity) (context as Activity).run { window.setSoftInputMode(window.attributes.softInputMode) }

    imageButtonUp.drawerArrow(context, searchUpIconDelay, searchUpIconDuration, inverse = false)

    when (searchCardBackgroundAnimation) {
        SearchBackgroundAnimation.RIPPLE -> {
            cardViewBackground.show(
                centerX = touchPoint.x,
                centerY = touchPoint.y,
                duration = searchBackgroundOpenDuration,
                delay = searchBackgroundOpenDelay,
                onAnimationEnd = { isOpen = true }
            )
        }
        SearchBackgroundAnimation.FADE -> {
            cardViewBackground.showFade(onAnimationEnd = { isOpen = true })
        }
    }
}

fun <T> setupClose(msv: MaterialSearchView<T>) = with(msv) {
    if (context is Activity) (context as Activity).run { window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING) }

    imageButtonUp.drawerArrow(context, searchUpIconDelay, searchUpIconDuration, inverse = true)

    when (searchCardBackgroundAnimation) {
        SearchBackgroundAnimation.RIPPLE -> {
            val location = IntArray(2)
            imageButtonUp.getLocationOnScreen(location)
            val x = location[0].toFloat()
            val y = location[1].toFloat()
            cardViewBackground.hide(
                centerX = x + imageButtonUp.x * 2 / 3,
                centerY = y - imageButtonUp.y * 2 / 3,
                duration = searchBackgroundCloseDuration,
                delay = searchBackgroundCloseDelay,
                onAnimationEnd = { isOpen = false }
            )
        }
        SearchBackgroundAnimation.FADE -> {
            cardViewBackground.hideFade(onAnimationEnd = { isOpen = false })
        }
    }

    searchTextView.text?.let { editable ->
        val total = searchTextEnterDuration + searchTextEnterDelay + searchTextExitDuration + searchTextExitDelay
        if (editable.isNotEmpty()) {
            val temp = onSearchTextChanged
            onSearchTextChanged = null
            searchSuggestionAdapter?.submitList(emptyList())
            when (searchTextAnimation) {
                SearchTextAnimation.TYPE -> {
                    searchTextView.deleteTextAnimated(searchTextEnterDuration, searchTextEnterDelay)
                    searchTextView.addTextAnimated(searchTextHint, searchTextExitDuration, searchTextExitDelay)
                    postDelayed({ onSearchTextChanged = temp }, total)
                }
                SearchTextAnimation.FADE -> {
                    searchTextView.fadeOut(searchTextEnterDuration, searchTextEnterDelay)
                    searchTextView.fadeIn(searchTextExitDuration, searchTextExitDelay)
                    postDelayed({ onSearchTextChanged = temp }, total)
                }
                SearchTextAnimation.NONE -> {
                    searchTextView.setText("")
                    postDelayed({ onSearchTextChanged = temp }, 0)
                }
            }
        }
    }
    return@with
}