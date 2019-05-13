package com.javiersc.extensions

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun Context.color(colorId: Int) = ContextCompat.getColor(this, colorId)
fun Context.drawable(drawableId: Int) = ContextCompat.getDrawable(this, drawableId)
fun Context.dimen(dimenId: Int) = this.resources.getDimension(dimenId)
fun Context.font(fontId: Int): Typeface = try {
    ResourcesCompat.getFont(this, fontId)!!
} catch (e: Resources.NotFoundException) {
    Typeface.DEFAULT
}