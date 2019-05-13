package com.javiersc.materialsearchview.view.materialsearchview.utils

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import com.google.android.material.textfield.TextInputEditText

internal class SearchTextInputEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : TextInputEditText(context, attrs) {

    internal var onKeyboardDismiss: (() -> Unit)? = null

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onKeyboardDismiss?.invoke()
            return true
        }
        return super.onKeyPreIme(keyCode, event)
    }

}

