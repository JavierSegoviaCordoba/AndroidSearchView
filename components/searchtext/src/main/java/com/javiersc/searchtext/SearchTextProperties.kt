package com.javiersc.searchtext

import android.graphics.Typeface

interface SearchTextProperties {

    var searchText: String
    var onSearchTextChanged: ((text: String) -> Unit)?
    var searchTextColor: Int
    var searchTextHint: String
    var searchTextHintColor: Int
    var searchTextFont: Typeface
    var searchTextAnimation: SearchTextAnimation
    var searchTextEnterDuration: Long
    var searchTextEnterDelay: Long
    var searchTextExitDuration: Long
    var searchTextExitDelay: Long

    var onSearchSubmit: ((String?) -> Unit)?
    var onKeyboardDismiss: (() -> Unit)?

}