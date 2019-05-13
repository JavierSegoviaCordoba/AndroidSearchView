package com.javiersc.materialsearchview.utils

internal fun filterList(text: CharSequence?, itemList: List<Any>, suggestionList: List<String>): List<Any> {
    return if (text != null) {
        val filteredSuggestionList = suggestionList.filter { it.contains(text.toString(), ignoreCase = true) }
        filteredSuggestionList.flatMap { textItem ->
            itemList.filter {
                it.toString().contains(textItem, ignoreCase = true)
            }
        }
    } else {
        itemList.toMutableList().clear()
        itemList
    }
}