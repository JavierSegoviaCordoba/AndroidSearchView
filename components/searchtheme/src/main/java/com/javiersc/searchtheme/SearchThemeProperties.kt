package com.javiersc.searchtheme

interface SearchThemeProperties {
    var searchTheme: SearchTheme
    var onSearchThemeChanged: ((searchTheme: SearchTheme) -> Unit)?
    fun changeSearchTheme(searchTheme: SearchTheme)
}

