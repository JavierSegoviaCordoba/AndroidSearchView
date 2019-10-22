package com.javiersc.androidsearchview.material.extensions

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.view.View
import android.view.WindowInsets
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

fun View.windowsInset(): WindowInsets? {
    this.setOnApplyWindowInsetsListener { v, insets ->
        return@setOnApplyWindowInsetsListener insets
    }
    return null
}

fun Context.statusBarHeight(): Int? {
    val resourceId = this.resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) this.resources.getDimensionPixelSize(resourceId) else null
}

fun Context.actionBarHeight(): Int {
    val styledAttributes = this.theme.obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
    val actionBarHeight = styledAttributes.getDimension(0, 0f).toInt()
    styledAttributes.recycle()
    return actionBarHeight
}