package com.javiersc.androidsearchview.ui.extension

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator

inline fun colorize(from: Int, to: Int, crossinline colorValue: (Int) -> Unit) {
    ValueAnimator.ofObject(ArgbEvaluator(), from, to).apply {
        addUpdateListener { value -> colorValue(value.animatedValue as Int) }
        duration = 500
        start()
    }
}
