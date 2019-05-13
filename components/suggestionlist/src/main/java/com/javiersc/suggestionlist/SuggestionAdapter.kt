/*
package com.javiersc.suggestionlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KProperty1


abstract class SuggestionAdapter<T, K>(
    var onClickListener: ((item: T, position: Int) -> Unit) = { _, _ -> },
    var onLongClickListener: ((item: T, position: Int) -> Unit) = { _, _ -> },
    propertyDiff: KProperty1<T, K>
) : ListAdapter<T, SuggestionAdapter<T, K>.SuggestionViewHolder<T>>(DiffCallback<T, K>(propertyDiff)) {

    abstract val layoutId: Int
    abstract fun viewHolder(view: View): SuggestionViewHolder<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        val viewHolder = viewHolder(view)
        viewHolder.onClickListener = { item: T, position: Int -> onClickListener(item, position) }
        viewHolder.onLongClickListener = { item: T, position: Int -> onLongClickListener(item, position) }
        return viewHolder
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }

    abstract inner class SuggestionViewHolder<T>(
        itemView: View,
        var onClickListener: ((item: T, position: Int) -> Unit) = { _, _ -> },
        var onLongClickListener: ((item: T, position: Int) -> Unit) = { _, _ -> }
    ) : RecyclerView.ViewHolder(itemView) {

        init {
            val item = getItem(adapterPosition)
            itemView.setOnClickListener { onClickListener(item, adapterPosition) }
            itemView.setOnLongClickListener { onLongClickListener(item, adapterPosition); true }
        }

        abstract fun bind(item: T)

    }

    internal class DiffCallback<T, K>(private val property: KProperty1<T, K>) :
        DiffUtil.ItemCallback<T>() {

        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
            property.get(oldItem) == property.get(newItem)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem

    }

}

inline fun <reified T, reified K> SuggestionAdapter<T, K>.filter(
    searchText: String,
    list: List<T>,
    vararg filterProperties: KProperty1<T, K>
) {
    filterProperties.map { kProperty1 ->
        val filteredList = list.filter { item ->
            val value = kProperty1.get(item).toString()
            value.contains(searchText)
        }
        this.submitList(filteredList)
    }
    this.submitList(emptyList())
}*/
