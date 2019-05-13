package com.javiersc.materialsearchview.setups

import android.content.Context
import android.content.res.TypedArray
import android.view.View
import com.javiersc.extensions.dp
import com.javiersc.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> setupRecyclerViewSuggestion(
    context: Context,
    attrs: TypedArray,
    msv: MaterialSearchView<T>
) {
    msv.recyclerViewSuggestionList.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
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
            val itemCount = msv.recyclerViewSuggestionList.layoutManager?.itemCount
            if (itemCount != 0) {
                val itemHeight = msv.recyclerViewSuggestionList.layoutManager?.getChildAt(0)?.measuredHeight ?: 0
                //todo change -4dp to correct value when attr is added
                msv.constrainLayoutParent.setPadding(0, 0, 0, (itemHeight - 4.dp()))
                msv.recyclerViewSuggestionList.removeOnLayoutChangeListener(this)
            }
        }

    })
}