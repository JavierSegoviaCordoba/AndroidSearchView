package com.javiersc.androidsearchview.material.inits

import android.view.View
import com.javiersc.androidsearchview.material.MaterialSearchView
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> MaterialSearchView<T>.initRecyclerViewSuggestion() {
    recyclerViewSuggestionList.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
        override fun onLayoutChange(
            v: View?,
            left: Int,
            top: Int,
            right: Int,
            bottom: Int,
            oldLeft: Int,
            oldTop: Int,
            oldRight: Int,
            oldBottom: Int
        ) {
            val itemCount = recyclerViewSuggestionList.layoutManager?.itemCount
            if (itemCount != 0) {
                val itemHeight = calculateItemHeight()
                val itemMargin = calculateItemMargin()
                constrainLayoutParent.setPadding(0, 0, 0, (itemHeight - itemMargin))
                recyclerViewSuggestionList.removeOnLayoutChangeListener(this)
            }
        }

        private fun calculateItemHeight(): Int {
            val child: View? = recyclerViewSuggestionList.layoutManager?.getChildAt(0)
            return child?.measuredHeight ?: 0
        }

        private fun calculateItemMargin(): Int {
            val child: View? = recyclerViewSuggestionList.layoutManager?.getChildAt(0)
            return (child?.paddingTop ?: 0) / 4
        }
    })
}