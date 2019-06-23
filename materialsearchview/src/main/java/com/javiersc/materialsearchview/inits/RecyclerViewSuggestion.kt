package com.javiersc.materialsearchview.inits

import android.view.View
import com.javiersc.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> initRecyclerViewSuggestion(msv: MaterialSearchView<T>) = with(msv) {
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
                val itemHeight = recyclerViewSuggestionList.layoutManager?.getChildAt(0)?.measuredHeight ?: 0
                val itemMargin = (recyclerViewSuggestionList.layoutManager?.getChildAt(0)?.paddingTop ?: 0) / 4
                constrainLayoutParent.setPadding(0, 0, 0, (itemHeight - itemMargin))
                recyclerViewSuggestionList.removeOnLayoutChangeListener(this)
            }
        }

    })
}