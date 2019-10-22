package com.javiersc.materialsearchview.inits

import android.content.res.TypedArray
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.R
import com.javiersc.materialsearchview.extensions.drawable
import com.javiersc.materialsearchview.extensions.voiceInput
import kotlinx.android.synthetic.main.material_search_view.view.*

internal fun <T> initSearchMicIcon(attrs: TypedArray, msv: MaterialSearchView<T>) = with(attrs) {

    val searchMicIconEnabled: Boolean =
        getBoolean(R.styleable.MaterialSearchView_searchMicIconEnabled, msv.searchMicIconEnabled)
    msv.searchMicIconEnabled = searchMicIconEnabled

    val searchMicIcon: Int = getResourceId(R.styleable.MaterialSearchView_searchMicIcon, 0)
    if (searchMicIcon != 0) msv.context.drawable(searchMicIcon)?.let { msv.searchMicIcon = it }
    else msv.searchMicIcon = msv.searchMicIcon

    val searchMicIconColor: Int =
        getColor(R.styleable.MaterialSearchView_searchMicIconColor, msv.searchMicIconColor)
    msv.searchMicIconColor = searchMicIconColor

    msv.imageButtonMic.setOnClickListener {
        msv.voiceInput()
        msv.onSearchMicIconListener?.invoke()
    }


}