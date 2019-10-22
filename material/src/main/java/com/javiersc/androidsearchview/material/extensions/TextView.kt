package com.javiersc.androidsearchview.material.extensions

import android.animation.ValueAnimator
import android.widget.TextView

fun TextView.deleteTextAnimated(duration: Long = 350, delay: Long = 0) {
    var text = this.text.toString()
    val numberOfChars = this.text.length
    val valueAnimator = ValueAnimator.ofInt(numberOfChars, 0)
    this.isCursorVisible = false
    valueAnimator.apply {
        addUpdateListener {
            val value = it.animatedValue as Int
            text = text.substring(0, value)
            this@deleteTextAnimated.text = text
            if (value == 0) this@deleteTextAnimated.apply {
                hint = ""
                isCursorVisible = true
            }
        }
        this.duration = duration
        startDelay = delay
    }
    valueAnimator.start()
}

fun TextView.addTextAnimated(text: String, duration: Long = 350, delay: Long = 0) {
    val numberOfChars = text.length
    val valueAnimator = ValueAnimator.ofInt(0, numberOfChars)
    valueAnimator.apply {
        addUpdateListener {
            val textTemp = text.substring(0, it.animatedValue as Int)
            this@addTextAnimated.hint = textTemp
        }
        this.duration = duration
        startDelay = delay
    }
    valueAnimator.start()
}

fun TextView.fadeOut(duration: Long = 350, delay: Long = 0) {
    val valueAnimator = ValueAnimator.ofFloat(1f, 0f)
    valueAnimator.apply {
        addUpdateListener {
            val value = it.animatedValue as Float
            this@fadeOut.alpha = value
            if (value == 0f) this@fadeOut.text = ""
        }
        this.duration = duration
        startDelay = delay
    }
    valueAnimator.start()
}

fun TextView.fadeIn(duration: Long = 350, delay: Long = 0) {
    val valueAnimator = ValueAnimator.ofFloat(0f, 1f)
    valueAnimator.apply {
        addUpdateListener { this@fadeIn.alpha = it.animatedValue as Float }
        this.duration = duration
        startDelay = delay
    }
    valueAnimator.start()
}