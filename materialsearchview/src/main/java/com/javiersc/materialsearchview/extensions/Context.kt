package com.javiersc.materialsearchview.extensions

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun Context.color(colorId: Int) = ContextCompat.getColor(this, colorId)
fun Context.drawable(drawableId: Int) = ContextCompat.getDrawable(this, drawableId)
fun Context.dimen(dimenId: Int) = this.resources.getDimension(dimenId)
fun Context.int(intId: Int) = this.resources.getInteger(intId)
fun Context.font(fontId: Int): Typeface = try {
    ResourcesCompat.getFont(this, fontId)!!
} catch (e: Resources.NotFoundException) {
    Typeface.DEFAULT
}

//TODO activity get real actionbar size
fun Context.statusBarHeight(): Int? {
    val resourceId = this.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        return this.resources.getDimensionPixelSize(resourceId)
    }
    return null
}