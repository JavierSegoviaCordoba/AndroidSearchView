package com.javiersc.androidsearchview.material.extensions

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP

private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics

val Float.dp: Float
    get() = TypedValue.applyDimension(COMPLEX_UNIT_DIP, this, displayMetrics)
