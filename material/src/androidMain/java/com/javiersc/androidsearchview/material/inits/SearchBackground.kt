package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R
import com.javiersc.androidsearchview.material.constants.SearchBackgroundAnimation
import com.javiersc.androidsearchview.material.extensions.dp
import kotlinx.android.synthetic.main.material_search_view.view.cardViewBackground
import kotlinx.android.synthetic.main.material_search_view.view.cardViewSearch
import kotlinx.android.synthetic.main.material_search_view.view.searchTextView

internal fun MaterialSearchView.initSearchBackground(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView = this
    with(attrs) {
        with(cardViewSearch) { layoutParams.height = layoutParams.height - 8.dp }
        val searchBackgroundColor: Int =
            getColor(R.styleable.MaterialSearchView_searchBackgroundColor, searchBackgroundColor)
        materialSearchView.searchBackgroundColor = searchBackgroundColor

        val searchBackgroundRippleColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchBackgroundRippleColor,
                materialSearchView.searchBackgroundRippleColor
            )
        materialSearchView.searchBackgroundRippleColor = searchBackgroundRippleColor

        val searchBackgroundOpenDuration: Long =
            getInteger(
                    R.styleable.MaterialSearchView_searchBackgroundOpenDuration,
                    materialSearchView.searchBackgroundOpenDuration.toInt()
                )
                .toLong()
        materialSearchView.searchBackgroundOpenDuration = searchBackgroundOpenDuration

        val searchBackgroundAnimation: Int =
            getInteger(
                R.styleable.MaterialSearchView_searchBackgroundAnimation,
                materialSearchView.searchBackgroundAnimation.value
            )
        materialSearchView.searchBackgroundAnimation =
            SearchBackgroundAnimation.values().find { anim: SearchBackgroundAnimation ->
                anim.value == searchBackgroundAnimation
            }
                ?: SearchBackgroundAnimation.FADE

        cardViewBackground.setOnClickListener {
            if (materialSearchView.isOpen) searchTextView.clearFocus()
        }
    }
}
