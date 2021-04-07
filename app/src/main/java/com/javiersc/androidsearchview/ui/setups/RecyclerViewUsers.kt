package com.javiersc.androidsearchview.ui.setups

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.androidsearchview.material.constants.SearchTheme
import com.javiersc.androidsearchview.model.User
import com.javiersc.androidsearchview.ui.adapter.UserAdapter
import com.javiersc.androidsearchview.ui.dummy.Lists
import com.javiersc.androidsearchview.ui.extension.toastShort

fun setupRecyclerView(recyclerView: RecyclerView, searchTheme: SearchTheme) {
    recyclerView.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = recyclerView.setupUserAdapter(Lists.USERS, searchTheme)
    }
}

private fun View.setupUserAdapter(
    userList: List<User>,
    searchTheme: SearchTheme
): ListAdapter<User, UserAdapter.UserViewHolder> {
    val userAdapter =
        UserAdapter().apply {
            onClick = { user, position -> context.toastShort("onClick $position: ${user.name}") }
            onLongClick =
                { user, position ->
                    context.toastShort("onLongClick $position: ${user.name}")
                }
            this.searchTheme = searchTheme
        }

    userAdapter.submitList(userList)
    return userAdapter
}
