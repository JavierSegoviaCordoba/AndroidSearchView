package com.javiersc.androidsearchview.material.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Interpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.google.android.material.circularreveal.CircularRevealCompat
import com.google.android.material.circularreveal.cardview.CircularRevealCardView
import kotlin.math.hypot


fun CircularRevealCardView.show(
    centerX: Float,
    centerY: Float,
    duration: Long = 300,
    delay: Long = 0,
    isBackground: Boolean = false,
    interpolator: Interpolator = FastOutSlowInInterpolator(),
    onAnimationEnd: (() -> Unit)
) = this.post {
    this.invisible()

    val windowManager = this.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val screenSize = Point()
    windowManager.defaultDisplay.getSize(screenSize)

    val startRadius =
        if (!isBackground) hypot(this.measuredWidth.toDouble(), this.measuredHeight.toDouble()).toFloat()
        else hypot(screenSize.x.toDouble(), screenSize.y.toDouble()).toFloat()

    if (this.isAttachedToWindow) {
        val animator = CircularRevealCompat.createCircularReveal(
            this,
            centerX,
            centerY,
            0f,
            startRadius
        ).apply {
            this.duration = duration
            this.interpolator = interpolator
            startDelay = delay
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator?) {
                    super.onAnimationStart(animation)
                    this@show.visible()
                }

                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    onAnimationEnd.invoke()
                }
            })
        }
        animator.start()
    }
}

fun CircularRevealCardView.hide(
    centerX: Float,
    centerY: Float,
    duration: Long = 300,
    delay: Long = 0,
    isBackground: Boolean = false,
    interpolator: Interpolator = FastOutSlowInInterpolator(),
    onAnimationEnd: (() -> Unit)
) = this.post {
    val windowManager = this.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val screenSize = Point()
    windowManager.defaultDisplay.getSize(screenSize)

    val startRadius =
        if (!isBackground) hypot(this.measuredWidth.toDouble(), this.measuredHeight.toDouble()).toFloat()
        else hypot(screenSize.x.toDouble(), screenSize.y.toDouble()).toFloat()

    if (this.isAttachedToWindow) {
        val animator = CircularRevealCompat.createCircularReveal(
            this,
            centerX,
            centerY,
            startRadius,
            0f
        ).apply {
            this.duration = duration
            this.interpolator = interpolator
            startDelay = delay
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    this@hide.invisible()
                    onAnimationEnd.invoke()
                }
            })
        }
        animator.start()
    }
}

fun CircularRevealCardView.showFade(
    duration: Long = 300,
    delay: Long = 0,
    interpolator: Interpolator = FastOutSlowInInterpolator(),
    onAnimationEnd: (() -> Unit)
) = this.post {
    val animation = AlphaAnimation(0f, 1f).apply {
        this.interpolator = interpolator
        this.duration = duration
        this.startOffset = delay
        this.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                this@showFade.isClickable = true
                onAnimationEnd.invoke()
            }

            override fun onAnimationStart(animation: Animation?) {
                this@showFade.visible()
                this@showFade.isClickable = false
            }
        })

    }
    this.startAnimation(animation)
}

fun CircularRevealCardView.hideFade(
    duration: Long = 300,
    delay: Long = 0,
    interpolator: Interpolator = FastOutSlowInInterpolator(),
    onAnimationEnd: (() -> Unit)
) = this.post {
    val animation = AlphaAnimation(1f, 0f).apply {
        this.interpolator = interpolator
        this.duration = duration
        this.startOffset = delay
        this.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                this@hideFade.invisible()
                this@hideFade.isClickable = true
                onAnimationEnd.invoke()
            }

            override fun onAnimationStart(animation: Animation?) {
                this@hideFade.isClickable = false
            }
        })
    }
    this.startAnimation(animation)
}