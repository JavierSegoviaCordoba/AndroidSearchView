package com.javiersc.materialsearchview.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.marginTop
import com.google.android.material.appbar.AppBarLayout
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.extensions.statusBarHeight
import kotlinx.android.synthetic.main.material_search_view.view.*


class SearchBehavior<T> @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) :
    CoordinatorLayout.Behavior<MaterialSearchView<T>>(context, attributeSet) {

    private val _context = context
    private val viewMargin = _context.statusBarHeight() ?: 0

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
                val cardViewHeightWithMargin = child.cardViewSearch.bottom + child.cardViewSearch.marginTop
                val appbarVisibleHeight = dependency.bottom - viewMargin
                if (appbarVisibleHeight <= cardViewHeightWithMargin)
                    child.constrainLayoutParent.translationY = appbarVisibleHeight - cardViewHeightWithMargin.toFloat()
                true
            }
            else -> super.onDependentViewChanged(parent, child, dependency)
        }
    }

}