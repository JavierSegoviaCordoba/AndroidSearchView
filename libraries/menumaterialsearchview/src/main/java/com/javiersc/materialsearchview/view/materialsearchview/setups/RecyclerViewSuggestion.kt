package com.javiersc.materialsearchview.view.materialsearchview.setups
/*

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.materialsearchview.view.menu.MenuMaterialSearchView
import kotlinx.android.synthetic.main.menu_msv.view.*

internal var itemList: List<Any> = listOf()

internal fun <T, VH : RecyclerView.ViewHolder> setupRecyclerViewSuggestion(
    menuMaterialSearchView: MenuMaterialSearchView,
    suggestionAdapter: ListAdapter<T, VH>,
    suggestionList: List<String>
) = with(menuMaterialSearchView) {
    recyclerViewSuggestions.layoutManager = LinearLayoutManager(context)
    @Suppress("UNCHECKED_CAST")
    this.adapter?.suggestionAdapter = suggestionAdapter as ListAdapter<Any, RecyclerView.ViewHolder>
    this.adapter?.suggestionList = suggestionList
    itemList = suggestionAdapter.currentList
    this.adapter?.suggestionAdapter?.submitList(emptyList())
    recyclerViewSuggestions.adapter = this.adapter?.suggestionAdapter
}

data class SuggestionAdapter<T, VH : RecyclerView.ViewHolder>(
    var suggestionAdapter: ListAdapter<T, VH>,
    var suggestionList: List<String>
)*/
