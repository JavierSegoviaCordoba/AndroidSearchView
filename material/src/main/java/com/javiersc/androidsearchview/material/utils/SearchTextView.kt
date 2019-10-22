package com.javiersc.androidsearchview.material.utils

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import com.google.android.material.textfield.TextInputEditText

class SearchTextView @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null
) : TextInputEditText(context, attributeSet) {

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            clearFocus()
            return true
        }
        return super.onKeyPreIme(keyCode, event)
    }

  /*  override fun performClick(): Boolean {
        super.performClick()
        return true
    }*/

}