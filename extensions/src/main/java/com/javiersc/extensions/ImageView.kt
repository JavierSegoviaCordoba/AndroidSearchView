package com.javiersc.extensions

import android.widget.ImageView
import androidx.core.content.ContextCompat

fun ImageView.drawable(drawableId: Int) = setImageDrawable(ContextCompat.getDrawable(context, drawableId))
