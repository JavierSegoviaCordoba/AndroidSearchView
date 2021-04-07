package com.javiersc.androidsearchview.material.setups

import android.view.WindowManager
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.constants.SearchBackgroundAnimation
import com.javiersc.androidsearchview.material.constants.SearchType
import com.javiersc.androidsearchview.material.extensions.dp
import com.javiersc.androidsearchview.material.extensions.drawerArrow
import com.javiersc.androidsearchview.material.extensions.getActivity
import com.javiersc.androidsearchview.material.extensions.hide
import com.javiersc.androidsearchview.material.extensions.hideFade
import com.javiersc.androidsearchview.material.extensions.show
import com.javiersc.androidsearchview.material.extensions.showFade
import com.javiersc.androidsearchview.material.inits.touchPoint
import kotlinx.android.synthetic.main.material_search_view.view.cardViewBackground
import kotlinx.android.synthetic.main.material_search_view.view.cardViewSearch
import kotlinx.android.synthetic.main.material_search_view.view.imageButtonUp

private var softInputMode: Int = 0

internal fun MaterialSearchView.setupOpen() {
    val activity = getActivity()
    activity?.let { softInputMode = it.window.attributes.softInputMode }

    if (searchUpIcon is DrawerArrowDrawable)
        imageButtonUp.drawerArrow(searchUpIconDelay, searchUpIconDuration, inverse = false)

    if (searchType == SearchType.MENU) {
        setupMenuItemLocation()
        cardViewSearch.show(
            centerX = touchPoint.x,
            centerY = touchPoint.y,
            duration = searchBackgroundOpenDuration,
            delay = searchBackgroundOpenDelay,
            onAnimationEnd = {}
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

internal fun MaterialSearchView.setupClose() {
    val activity = getActivity()
    activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

    if (searchUpIcon is DrawerArrowDrawable)
        imageButtonUp.drawerArrow(searchUpIconDelay, searchUpIconDuration, inverse = true)

    if (searchType == SearchType.MENU) {
        setupMenuItemLocation()
        cardViewSearch.hide(
            centerX = touchPoint.x,
            centerY = touchPoint.y,
            duration = searchBackgroundOpenDuration,
            delay = searchBackgroundOpenDelay,
            onAnimationEnd = {}
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
