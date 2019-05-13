package com.javiersc.materialsearchview.view.materialsearchview

import android.content.Context
import com.javiersc.extensions.color
import com.javiersc.materialsearchview.R

internal open class DefaultValues(context: Context) {

    private val _context = context

    inner class Light : DefaultValues(_context) {
        var colorText: Int = _context.color(R.color.searchTextLight)
        var colorTextHint: Int = _context.color(R.color.searchTextHintLight)
    }

    inner class Dark {
        var colorText: Int = _context.color(R.color.searchTextDark)
        var colorTextHint: Int = _context.color(R.color.searchTextHintDark)
    }

}


