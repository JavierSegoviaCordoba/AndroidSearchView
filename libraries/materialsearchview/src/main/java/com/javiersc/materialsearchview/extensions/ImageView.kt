package com.javiersc.materialsearchview.extensions

import android.animation.ValueAnimator
import android.content.Context
import android.widget.ImageView
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable

internal fun ImageView.drawerArrow(context: Context, delay: Long, duration: Long = 400, inverse: Boolean = false) {
    val valueAnimator = if (!inverse) ValueAnimator.ofFloat(0f, 1f) else ValueAnimator.ofFloat(1f, 0f)
    valueAnimator.duration = duration
    valueAnimator.addUpdateListener { animation ->
        val drawerIcon = DrawerArrowDrawable(context).apply {
            progress = animation?.animatedValue as Float
            setVerticalMirror(inverse)
        }
        this.setImageDrawable(drawerIcon)
    }
    valueAnimator.startDelay = delay
    valueAnimator.start()
}
