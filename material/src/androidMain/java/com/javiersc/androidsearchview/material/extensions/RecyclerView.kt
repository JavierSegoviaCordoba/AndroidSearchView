package com.javiersc.androidsearchview.material.extensions

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

private var marginDecoration = Margin(0, 0, 0, 0)
private var paddingDecoration = Padding(0, 0, 0, 0)

fun RecyclerView.itemMargin(margin: Int) {
    this.removeItemDecoration(marginDecoration)
    marginDecoration = Margin(margin, margin, margin, margin)
    this.addItemDecoration(marginDecoration)
}

fun RecyclerView.itemPadding(padding: Int) {
    this.removeItemDecoration(paddingDecoration)
    paddingDecoration = Padding(padding, padding, padding, padding)
    this.addItemDecoration(paddingDecoration)
}

fun RecyclerView.itemPadding(left: Int, top: Int, right: Int, bottom: Int) =
    this.addItemDecoration(Padding(left, top, right, bottom))

fun RecyclerView.itemMargin(left: Int, top: Int, right: Int, bottom: Int) =
    this.addItemDecoration(Margin(left, top, right, bottom))

private class Margin(
    private val left: Int,
    private val top: Int,
    private val right: Int,
    private val bottom: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            left = this@Margin.left
            if (parent.getChildAdapterPosition(view) == 0) top = this@Margin.top
            right = this@Margin.right
            bottom = this@Margin.bottom
        }
    }
}

private class Padding(
    private val left: Int,
    private val top: Int,
    private val right: Int,
    private val bottom: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val lastPosition = state.itemCount - 1
        if (parent.layoutManager?.itemCount == 1) view.setPadding(left, top, right, bottom)
        else
            when {
                parent.getChildAdapterPosition(view) == 0 ->
                    view.setPadding(left, top, right, bottom / 2)
                parent.getChildAdapterPosition(view) == lastPosition ->
                    view.setPadding(left, top / 2, right, bottom)
                else -> view.setPadding(left, top / 2, right, bottom / 2)
            }
        parent.post { parent.invalidateItemDecorations() }
    }
}
