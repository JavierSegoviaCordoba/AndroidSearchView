package com.javiersc.suggestionlist

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

interface SuggestionListFields<T> {
    var searchSuggestionAdapter: ListAdapter<in T, RecyclerView.ViewHolder>?
    var onSearchSuggestionFilter: ((text: String) -> Unit)?
}