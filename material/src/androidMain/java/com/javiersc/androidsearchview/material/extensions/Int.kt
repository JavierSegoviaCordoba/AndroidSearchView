package com.javiersc.androidsearchview.material.extensions

import android.content.res.ColorStateList
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP

private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics

val Int.dp: Int
    get() = TypedValue.applyDimension(COMPLEX_UNIT_DIP, this.toFloat(), displayMetrics).toInt()

fun Int.colorStateList(): ColorStateList = ColorStateList.valueOf(this)
