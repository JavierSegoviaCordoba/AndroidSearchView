package com.javiersc.androidsearchview.ui.extension
/*

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.extensions.dp

fun RecyclerView.margin(marginDp: Int) {
    this.addItemDecoration(MarginItemDecoration(marginDp.dp()))
}

fun RecyclerView.smoothSnapToPosition(
    position: Int,
    snapMode: Int = LinearSmoothScroller.SNAP_TO_START,
    offSet: Int = 8.dp()
) {
    val smoothScroller = object : LinearSmoothScroller(this.context) {

        override fun calculateDtToFit(viewStart: Int, viewEnd: Int, boxStart: Int, boxEnd: Int, snapPreference: Int) =
            (boxStart) - (viewStart) + offSet

        override fun getVerticalSnapPreference(): Int = snapMode

        override fun getHorizontalSnapPreference(): Int = snapMode
    }
    smoothScroller.targetPosition = position
    layoutManager?.startSmoothScroll(smoothScroller)
}

private class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) top = spaceHeight
            left = spaceHeight
            right = spaceHeight
            bottom = spaceHeight
        }
    }
}
*/
