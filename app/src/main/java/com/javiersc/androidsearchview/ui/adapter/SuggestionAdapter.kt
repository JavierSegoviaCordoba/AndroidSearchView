package com.javiersc.androidsearchview.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.androidsearchview.R
import com.javiersc.androidsearchview.material.constants.SearchTheme
import com.javiersc.androidsearchview.material.extensions.color
import com.javiersc.androidsearchview.material.extensions.drawable
import com.javiersc.androidsearchview.model.User
import kotlinx.android.synthetic.main.item_suggestion.view.imageViewProfile
import kotlinx.android.synthetic.main.item_suggestion.view.textViewEmail
import kotlinx.android.synthetic.main.item_suggestion.view.textViewName

class SuggestionAdapter :
    ListAdapter<User, SuggestionAdapter.SuggestionViewHolder>(TaskDiffCallback()) {

    var onClick: ((User, Int) -> Unit)? = null
    var onLongClick: ((User, Int) -> Unit)? = null

    var searchTheme: SearchTheme = SearchTheme.LIGHT

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = inflater.inflate(R.layout.item_suggestion, parent, false)
        return SuggestionViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SuggestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) =
            with(itemView) {
                setOnClickListener { onClick?.invoke(user, adapterPosition) }
                setOnLongClickListener { onLongClick?.invoke(user, adapterPosition).let { true } }

                if (searchTheme == SearchTheme.LIGHT) {
                    textViewName.setTextColor(context.color(R.color.searchTextLight))
                    textViewEmail.setTextColor(context.color(R.color.searchTextHintLight))
                } else {
                    textViewName.setTextColor(context.color(R.color.searchTextDark))
                    textViewEmail.setTextColor(context.color(R.color.searchTextHintDark))
                }

                imageViewProfile.setImageDrawable(itemView.context.drawable(user.imageId))

                textViewName.text = user.name
                textViewEmail.text = user.email
            }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.imageId == newItem.imageId

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
    }
}
