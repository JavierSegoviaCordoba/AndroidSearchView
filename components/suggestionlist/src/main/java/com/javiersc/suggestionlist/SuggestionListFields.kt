package com.javiersc.suggestionlist

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

interface SuggestionListFields<T> {
    var searchSuggestionAdapter: ListAdapter<out T, RecyclerView.ViewHolder>?
}