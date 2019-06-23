package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.constants.SearchBackgroundAnimation
import com.javiersc.materialsearchview.extensions.dp
import kotlinx.android.synthetic.main.material_search_view.view.*


internal fun <T> initSearchBackground(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {
    with(msv.cardViewSearch) { layoutParams.height = layoutParams.height - 8.dp }

    val searchBackgroundColor: Int =
        getColor(R.styleable.MaterialSearchView_searchBackgroundColor, msv.searchBackgroundColor)
    msv.searchBackgroundColor = searchBackgroundColor

    val searchBackgroundRippleColor: Int =
        getColor(R.styleable.MaterialSearchView_searchBackgroundRippleColor, msv.searchBackgroundRippleColor)
    msv.searchBackgroundRippleColor = searchBackgroundRippleColor

    val searchBackgroundOpenDuration: Long =
        getInteger(
            R.styleable.MaterialSearchView_searchBackgroundOpenDuration,
            msv.searchBackgroundOpenDuration.toInt()
        ).toLong()
    msv.searchBackgroundOpenDuration = searchBackgroundOpenDuration

    val searchCardBackgroundAnimation: Int =
        getInteger(R.styleable.MaterialSearchView_searchBackgroundAnimation, msv.searchBackgroundAnimation.value)

    msv.searchBackgroundAnimation =
        SearchBackgroundAnimation.values().find { it.value == searchCardBackgroundAnimation }
            ?: SearchBackgroundAnimation.FADE

    msv.cardViewBackground.setOnClickListener { if (msv.isOpen) msv.searchTextView.clearFocus() }
}
