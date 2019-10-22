package com.javiersc.materialsearchview.extensions

import android.animation.ValueAnimator
import android.widget.ImageView
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.content.ContextCompat

internal fun ImageView.drawerArrow(delay: Long, duration: Long = 400, inverse: Boolean = false) {
    if (this.drawable is DrawerArrowDrawable) {
        val drawerArrowDrawable = this.drawable as DrawerArrowDrawable
        val valueAnimator = if (!inverse) ValueAnimator.ofFloat(0f, 1f) else ValueAnimator.ofFloat(1f, 0f)
        valueAnimator.duration = duration
        valueAnimator.addUpdateListener { animation ->
            drawerArrowDrawable.apply {
                progress = animation?.animatedValue as Float
                setVerticalMirror(inverse)
            }
            this.setImageDrawable(drawerArrowDrawable)
        }
        valueAnimator.startDelay = delay
        valueAnimator.start()
    }
}

fun ImageView.drawable(drawableId: Int) = setImageDrawable(ContextCompat.getDrawable(context, drawableId))
