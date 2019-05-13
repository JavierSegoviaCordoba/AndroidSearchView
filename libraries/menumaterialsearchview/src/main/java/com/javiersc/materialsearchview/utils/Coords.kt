package com.javiersc.materialsearchview.utils

import com.google.android.material.circularreveal.cardview.CircularRevealCardView
import com.javiersc.extensions.dp

internal data class Coords(val x: Float, val y: Float) {

    companion object {

        internal fun searchCard(position: Int = 0, cardViewSearch: CircularRevealCardView): Coords {
            val centerX =
                cardViewSearch.measuredWidth.toFloat() - position * 24.dp() - 20.dp()
            val centerY = cardViewSearch.measuredHeight.toFloat() / 2 - 1.dp()

            return Coords(centerX, centerY)
        }

        internal fun backgroundCard(position: Int = 0, cardViewSearch: CircularRevealCardView): Coords {
            val coords = searchCard(position, cardViewSearch)
            val centerX = coords.x + 4.dp()
            val centerY = coords.y + 4.dp()
            return Coords(centerX, centerY)
        }

    }

}
