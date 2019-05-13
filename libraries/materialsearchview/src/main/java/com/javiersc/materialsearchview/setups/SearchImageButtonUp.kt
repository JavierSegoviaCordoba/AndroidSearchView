package com.javiersc.materialsearchview.setups

import android.content.Context
import android.content.res.TypedArray
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> setupSearchImageButtonUp(context: Context, attrs: TypedArray, msv: MaterialSearchView<T>) =
    with(attrs) {

        val searchUpIconDuration: Long =
            getInteger(R.styleable.MaterialSearchView_searchUpIconDuration, msv.searchUpIconDuration.toInt()).toLong()
        msv.searchUpIconDuration = searchUpIconDuration

        val searchUpIconDelay: Long =
            getInteger(R.styleable.MaterialSearchView_searchUpIconDelay, msv.searchUpIconDelay.toInt()).toLong()
        msv.searchUpIconDelay = searchUpIconDelay

        with(msv) {
            imageButtonUp.setImageDrawable(DrawerArrowDrawable(context))
            imageButtonUp.setOnClickListener {
                if (isOpen) {
                    searchTextView.clearFocus()
                }
                onSearchUpIconListener?.invoke()
            }
        }
    }