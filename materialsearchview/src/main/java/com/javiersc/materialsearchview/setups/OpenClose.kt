package com.javiersc.materialsearchview.setups

import android.app.Activity
import android.content.ContextWrapper
import android.view.WindowManager
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.constants.SearchBackgroundAnimation
import com.javiersc.materialsearchview.constants.SearchTextAnimation
import com.javiersc.materialsearchview.constants.SearchType
import com.javiersc.materialsearchview.extensions.*
import com.javiersc.materialsearchview.inits.touchPoint
import kotlinx.android.synthetic.main.material_search_view.view.*


private var softInputMode: Int = 0

internal fun <T> setupOpen(msv: MaterialSearchView<T>): Unit = with(msv) {
    println(softInputMode)
    val activity = getActivity(msv)
    activity?.let { softInputMode = it.window.attributes.softInputMode }

    searchUpIcon?.let { imageButtonUp.drawerArrow(context, searchUpIconDelay, searchUpIconDuration, inverse = false) }

    if (searchType == SearchType.MENU) {
        setupMenuItemLocation(this)
        cardViewSearch.show(
            centerX = touchPoint.x,
            centerY = touchPoint.y,
            duration = searchBackgroundOpenDuration,
            delay = searchBackgroundOpenDelay,
            onAnimationEnd = { }
        )
    }

    when (searchBackgroundAnimation) {
        SearchBackgroundAnimation.RIPPLE -> {
            cardViewBackground.show(
                centerX = touchPoint.x + 4.dp,
                centerY = touchPoint.y + 4.dp,
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

internal fun <T> setupClose(msv: MaterialSearchView<T>): Unit = with(msv) {
    val activity = getActivity(msv)
    activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

    searchUpIcon?.let { imageButtonUp.drawerArrow(context, searchUpIconDelay, searchUpIconDuration, inverse = true) }

    if (searchType == SearchType.MENU) {
        setupMenuItemLocation(this)
        cardViewSearch.hide(
            centerX = touchPoint.x,
            centerY = touchPoint.y,
            duration = searchBackgroundOpenDuration,
            delay = searchBackgroundOpenDelay,
            onAnimationEnd = { }
        )
    } else {
        val location = IntArray(2)
        imageButtonUp.getLocationOnScreen(location)
        val x = location[0].toFloat()
        val y = location[1].toFloat()
        touchPoint.x = x + imageButtonUp.x * 2 / 3
        touchPoint.y = y - imageButtonUp.y * 2 / 3
    }

    when (searchBackgroundAnimation) {
        SearchBackgroundAnimation.RIPPLE -> {
            cardViewBackground.hide(
                centerX = touchPoint.x + 4.dp,
                centerY = touchPoint.y + 4.dp,
                duration = searchBackgroundCloseDuration,
                delay = searchBackgroundCloseDelay,
                onAnimationEnd = {
                    isOpen = false
                    activity?.let { it.window.attributes.softInputMode = softInputMode }
                }
            )
        }
        SearchBackgroundAnimation.FADE -> {
            cardViewBackground.hideFade(onAnimationEnd = { isOpen = false })
        }
    }

    searchTextView.text?.let { editable ->
        val total = searchTextEnterDuration + searchTextEnterDelay + searchTextExitDuration + searchTextExitDelay
        if (editable.isNotEmpty()) {
            val tempText = onSearchTextChanged
            val tempFilter = onSearchSuggestionFilter
            onSearchTextChanged = null
            onSearchSuggestionFilter = null
            searchSuggestionAdapter?.submitList(emptyList())
            when (searchTextAnimation) {
                SearchTextAnimation.TYPE -> {
                    searchTextView.deleteTextAnimated(searchTextEnterDuration, searchTextEnterDelay)
                    searchTextView.addTextAnimated(searchTextHint, searchTextExitDuration, searchTextExitDelay)
                    postDelayed({
                        onSearchTextChanged = tempText
                        onSearchSuggestionFilter = tempFilter
                    }, total)
                }
                SearchTextAnimation.FADE -> {
                    searchTextView.fadeOut(searchTextEnterDuration, searchTextEnterDelay)
                    searchTextView.fadeIn(searchTextExitDuration, searchTextExitDelay)
                    postDelayed({
                        onSearchTextChanged = tempText
                        onSearchSuggestionFilter = tempFilter
                    }, total)
                }
                SearchTextAnimation.NONE -> {
                    searchTextView.setText("")
                    postDelayed({
                        onSearchTextChanged = tempText
                        onSearchSuggestionFilter = tempFilter
                    }, 0)
                }
            }
        }
    }
}

private fun <T> getActivity(msv: MaterialSearchView<T>): Activity? {
    var context = msv.context
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}