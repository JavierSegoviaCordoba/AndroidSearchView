package com.javiersc.materialsearchview

import android.graphics.drawable.Drawable
import com.javiersc.materialsearchview.utils.SearchBackgroundAnimation

interface MaterialSearchViewProperties {

    var searchBackgroundColor: Int
    var searchBackgroundRippleColor: Int
    var searchBackgroundOpenDuration: Long
    var searchBackgroundOpenDelay: Long
    var searchBackgroundCloseDuration: Long
    var searchBackgroundCloseDelay: Long
    var searchBackgroundAnimation: SearchBackgroundAnimation

    var searchCardsParentTranslationY: Float

    var searchCardBackgroundColor: Int
    var searchCardCornerRadius: Float
    var searchCardElevation: Float

    var searchUpIcon: Drawable
    var searchUpIconDuration: Long
    var searchUpIconDelay: Long

    var isOpen: Boolean
    var onSearchUpIconListener: (() -> Unit)?
    fun open()
    fun close()

}