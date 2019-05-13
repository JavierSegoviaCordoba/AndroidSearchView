package com.javiersc.androidsearchview.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.androidsearchview.R
import com.javiersc.androidsearchview.model.User
import com.javiersc.extensions.color
import com.javiersc.extensions.drawable
import com.javiersc.searchtheme.SearchTheme
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(private val onClickListener: OnClickListener, private val searchTheme: SearchTheme) :
    ListAdapter<User, UserAdapter.UserViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = inflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(viewHolder, onClickListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class UserViewHolder(itemView: View, private val onClickListener: OnClickListener) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) = with(itemView) {
            setOnClickListener { onClickListener.onClick(user, adapterPosition) }
            setOnLongClickListener { onClickListener.onLongClick(user, adapterPosition).let { true } }

            if (searchTheme == SearchTheme.LIGHT) {
                cardView.setCardBackgroundColor(context.color(R.color.searchCardBackgroundLight))
                textViewName.setTextColor(context.color(R.color.searchTextLight))
                textViewCompany.setTextColor(context.color(R.color.searchTextLight))
                textViewEmail.setTextColor(context.color(R.color.searchTextHintLight))
            } else {
                cardView.setCardBackgroundColor(context.color(R.color.appBarLayoutDark))
                textViewName.setTextColor(context.color(R.color.searchTextDark))
                textViewCompany.setTextColor(context.color(R.color.searchTextDark))
                textViewEmail.setTextColor(context.color(R.color.searchTextHintDark))
            }


            imageViewProfile.setImageDrawable(context.drawable(user.imageId))

            textViewName.text = user.name
            textViewCompany.text = user.company
            textViewEmail.text = user.email
        }
    }

    interface OnClickListener {
        fun onClick(user: User, position: Int)
        fun onLongClick(user: User, position: Int)
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(
            oldItem: User,
            newItem: User
        ): Boolean = oldItem.imageId == newItem.imageId

        override fun areContentsTheSame(
            oldItem: User,
            newItem: User
        ): Boolean = oldItem == newItem

    }

}
