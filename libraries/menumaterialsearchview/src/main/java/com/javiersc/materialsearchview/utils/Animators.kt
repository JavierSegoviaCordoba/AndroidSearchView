package com.javiersc.materialsearchview.utils
/*

import android.animation.ValueAnimator
import android.content.Context
import android.view.ViewGroup
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import com.javiersc.materialsearchview.view.menu.upDrawableDefined
import kotlinx.android.synthetic.main.menu_msv.view.*


internal fun upAnimation(context: Context, vg: ViewGroup, delay: Long, duration: Long = 400, inverse: Boolean = false) {
    if (!upDrawableDefined) {
        val valueAnimator = if (!inverse) ValueAnimator.ofFloat(0f, 1f) else ValueAnimator.ofFloat(1f, 0f)
        valueAnimator.duration = duration
        valueAnimator.addUpdateListener { animation ->
            val drawerIcon = DrawerArrowDrawable(context).apply { progress = animation?.animatedValue as Float }
            vg.imageButtonUp.setImageDrawable(drawerIcon)
        }
        valueAnimator.startDelay = delay
        valueAnimator.start()
    }
}*/
