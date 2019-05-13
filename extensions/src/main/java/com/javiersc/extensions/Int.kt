package com.javiersc.extensions

import android.content.res.ColorStateList
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP

private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics

fun Int.dp(): Int = TypedValue.applyDimension(COMPLEX_UNIT_DIP, this.toFloat(),
    displayMetrics
).toInt()

fun Int.colorStateList(): ColorStateList = ColorStateList.valueOf(this)