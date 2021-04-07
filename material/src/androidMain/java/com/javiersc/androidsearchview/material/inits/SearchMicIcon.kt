package com.javiersc.androidsearchview.material.inits

import android.content.res.TypedArray
import com.javiersc.androidsearchview.material.MaterialSearchView
import com.javiersc.androidsearchview.material.R
import com.javiersc.androidsearchview.material.extensions.drawable
import com.javiersc.androidsearchview.material.extensions.voiceInput
import kotlinx.android.synthetic.main.material_search_view.view.imageButtonMic

internal fun MaterialSearchView.initSearchMicIcon(attrs: TypedArray) {
    val materialSearchView: MaterialSearchView = this
    with(attrs) {
        val searchMicIconEnabled: Boolean =
            getBoolean(
                R.styleable.MaterialSearchView_searchMicIconEnabled,
                materialSearchView.searchMicIconEnabled
            )
        materialSearchView.searchMicIconEnabled = searchMicIconEnabled

        val searchMicIcon: Int = getResourceId(R.styleable.MaterialSearchView_searchMicIcon, 0)
        if (searchMicIcon != 0)
            materialSearchView.context.drawable(searchMicIcon)?.let { icon ->
                materialSearchView.searchMicIcon = icon
            }
        else materialSearchView.searchMicIcon = materialSearchView.searchMicIcon

        val searchMicIconColor: Int =
            getColor(
                R.styleable.MaterialSearchView_searchMicIconColor,
                materialSearchView.searchMicIconColor
            )
        materialSearchView.searchMicIconColor = searchMicIconColor

        imageButtonMic.setOnClickListener {
            materialSearchView.voiceInput()
            materialSearchView.onSearchMicIconListener?.invoke()
        }
    }
}
