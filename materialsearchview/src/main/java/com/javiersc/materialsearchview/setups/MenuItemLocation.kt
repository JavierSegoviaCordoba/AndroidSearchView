package com.javiersc.materialsearchview.setups

import android.view.View
import androidx.core.view.marginRight
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.extensions.dp
import com.javiersc.materialsearchview.inits.touchPoint
import kotlinx.android.synthetic.main.material_search_view.view.*


internal fun <T> setupMenuItemLocation(msv: MaterialSearchView<T>): Unit = with(msv) {
    searchMenuItem?.let {
        val location = IntArray(2)
        val itemView = rootView.findViewById<View>(it.itemId)
        itemView.getLocationOnScreen(location)
        val x = location[0].toFloat()
        touchPoint.x = x + itemView.measuredWidth * 2 / 5
    } ?: run { touchPoint.x = constrainLayoutParent.measuredWidth - 24f.dp - cardViewSearch.marginRight }
    touchPoint.y = (cardViewSearch.measuredHeight / 2).toFloat()
}