package com.javiersc.materialsearchview.setups

import android.view.WindowManager
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.constants.SearchBackgroundAnimation
import com.javiersc.materialsearchview.constants.SearchType
import com.javiersc.materialsearchview.extensions.*
import com.javiersc.materialsearchview.inits.touchPoint
import kotlinx.android.synthetic.main.material_search_view.view.*


private var softInputMode: Int = 0

internal fun <T> setupOpen(msv: MaterialSearchView<T>): Unit = with(msv) {
    val activity = getActivity()
    activity?.let { softInputMode = it.window.attributes.softInputMode }

    if (searchUpIcon is DrawerArrowDrawable)
        imageButtonUp.drawerArrow(searchUpIconDelay, searchUpIconDuration, inverse = false)

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
                onAnimationEnd = { isOpen = true })
        }
        SearchBackgroundAnimation.FADE -> {
            cardViewBackground.showFade(onAnimationEnd = { isOpen = true })
        }
    }
}

internal fun <T> setupClose(msv: MaterialSearchView<T>): Unit = with(msv) {
    val activity = getActivity()
    activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

    if (searchUpIcon is DrawerArrowDrawable)
        imageButtonUp.drawerArrow(searchUpIconDelay, searchUpIconDuration, inverse = true)

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

    clearSearchText()
}