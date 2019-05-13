package com.javiersc.androidsearchview.ui.extension

import android.content.Context
import android.widget.Toast

fun Context.toastShort(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
fun Context.toastLong(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()