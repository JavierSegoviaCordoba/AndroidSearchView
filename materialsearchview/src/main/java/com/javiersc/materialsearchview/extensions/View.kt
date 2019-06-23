package com.javiersc.materialsearchview.extensions

import android.content.Context
import android.graphics.PointF
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager


fun View.visible() {
    if (this.visibility != View.VISIBLE) this.visibility = View.VISIBLE
}

fun View.invisible() {
    if (this.visibility != View.INVISIBLE) this.visibility = View.INVISIBLE
}

fun View.gone() {
    if (this.visibility != View.GONE) this.visibility = View.GONE
}

fun View.getTouchPoint(): PointF {
    val point = PointF()
    this.setOnTouchListener { v, event ->
        point.x = event.x
        point.y = event.y
        true
    }
    return point
}


fun View.hideSoftKeyboard(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun showSoftKeyboard(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

fun View.margins(margin: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val layoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.setMargins(margin, margin, margin, margin)
        this.requestLayout()
    }
}

fun View.margins(left: Int, top: Int, right: Int, bottom: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val layoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.setMargins(left, top, right, bottom)
        this.requestLayout()
    }
}

fun View.marginLeft(marginLeft: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val layoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
        with(layoutParams) {
            setMargins(marginLeft, topMargin, rightMargin, bottomMargin)
            marginStart = marginLeft
            marginEnd = rightMargin
        }
        this.requestLayout()
    }
}

fun View.marginTop(marginTop: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val layoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
        with(layoutParams) {
            setMargins(leftMargin, marginTop, rightMargin, bottomMargin)
            marginStart = leftMargin
            marginEnd = rightMargin
        }
        this.requestLayout()
    }
}

fun View.marginRight(marginRight: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val layoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
        with(layoutParams) {
            setMargins(leftMargin, topMargin, marginRight, bottomMargin)
            marginStart = leftMargin
            marginEnd = marginRight
        }
        this.requestLayout()
    }
}

fun View.marginBottom(marginBottom: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val layoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
        with(layoutParams) {
            setMargins(leftMargin, topMargin, rightMargin, marginBottom)
            marginStart = leftMargin
            marginEnd = rightMargin
        }
        this.requestLayout()
    }
}