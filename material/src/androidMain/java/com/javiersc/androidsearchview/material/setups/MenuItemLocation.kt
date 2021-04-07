package com.javiersc.androidsearchview.material.setups

import android.view.View
import androidx.core.view.marginRight
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.extensions.dp
import com.javiersc.androidsearchview.material.inits.touchPoint
import kotlinx.android.synthetic.main.material_search_view.view.cardViewSearch
import kotlinx.android.synthetic.main.material_search_view.view.constrainLayoutParent

internal fun MaterialSearchView.setupMenuItemLocation() {
    searchMenuItem?.let {
        val location = IntArray(2)
        val itemView = rootView.findViewById<View>(it.itemId)
        itemView.getLocationOnScreen(location)
        val x = location[0].toFloat()
        touchPoint.x = x + itemView.measuredWidth * 2 / 5
    }
        ?: run {
            touchPoint.x = constrainLayoutParent.measuredWidth - 24f.dp - cardViewSearch.marginRight
        }
    touchPoint.y = (cardViewSearch.measuredHeight / 2).toFloat()
}
