package com.javiersc.materialsearchview.utils

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.extensions.statusBarHeight
import kotlinx.android.synthetic.main.material_search_view.view.*


class SearchBehavior<T> @JvmOverloads constructor(val context: Context, attributeSet: AttributeSet? = null) :
    CoordinatorLayout.Behavior<MaterialSearchView<T>>(context, attributeSet) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: MaterialSearchView<T>, dependency: View): Boolean {
        return true
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: MaterialSearchView<T>,
        dependency: View
    ): Boolean {
        return when (dependency) {
            is AppBarLayout -> {
                val insetTop =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) child.rootWindowInsets.systemWindowInsetTop
                    else child.context.statusBarHeight() ?: 0

                val searchCardMeasured = with(child) { searchCardHeight + searchCardMarginTop + searchCardMarginBottom }
                val appbarVisibleHeight = dependency.bottom - insetTop
                val ratio = if (appbarVisibleHeight >= 1) insetTop / appbarVisibleHeight else insetTop

                if (appbarVisibleHeight <= searchCardMeasured)
                    child.constrainLayoutParent.translationY = appbarVisibleHeight - ratio - searchCardMeasured
                true
            }
            else -> super.onDependentViewChanged(parent, child, dependency)
        }
    }

}