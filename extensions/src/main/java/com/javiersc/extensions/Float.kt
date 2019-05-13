package com.javiersc.extensions

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP

private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics

fun Float.dp(): Float {
    return TypedValue.applyDimension(COMPLEX_UNIT_DIP, this, displayMetrics)
}