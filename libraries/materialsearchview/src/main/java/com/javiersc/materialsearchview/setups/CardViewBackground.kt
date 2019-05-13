package com.javiersc.materialsearchview.setups

import android.content.Context
import android.content.res.TypedArray
import com.javiersc.extensions.dp
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.utils.SearchBackgroundAnimation
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> setupCardViewBackground(context: Context, attrs: TypedArray, msv: MaterialSearchView<T>) {
    with(msv.cardViewSearch) { layoutParams.height = layoutParams.height - 8.dp() }
    with(attrs) {

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
            getInteger(
                R.styleable.MaterialSearchView_searchBackgroundAnimation,
                msv.searchCardBackgroundAnimation.value
            )

        msv.searchCardBackgroundAnimation =
            SearchBackgroundAnimation.values().first { it.value == searchCardBackgroundAnimation }

        msv.cardViewBackground.setOnClickListener {
            msv.searchTextView.clearFocus()
        }

    }
}
