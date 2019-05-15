package com.javiersc.androidsearchview.ui.setups

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.androidsearchview.App
import com.javiersc.androidsearchview.model.User
import com.javiersc.androidsearchview.ui.adapter.UserAdapter
import com.javiersc.androidsearchview.ui.dummy.Lists
import com.javiersc.androidsearchview.ui.extension.toastShort
import com.javiersc.extensions.dp
import com.javiersc.extensions.itemMargin
import com.javiersc.searchtheme.SearchTheme

fun setupRecyclerView(recyclerView: RecyclerView, searchTheme: SearchTheme) {
    recyclerView.apply {
        itemMargin(8.dp())
        layoutManager = LinearLayoutManager(context)
        adapter = setupUserAdapter(Lists.USERS, searchTheme)
    }
}

private fun setupUserAdapter(
    userList: List<User>,
    searchTheme: SearchTheme
): ListAdapter<User, UserAdapter.UserViewHolder> {
    val userAdapter: ListAdapter<User, UserAdapter.UserViewHolder> =
        UserAdapter(object : UserAdapter.OnClickListener {
            override fun onClick(user: User, position: Int) = App.appContext.toastShort("onClick: ${user.name}")
            override fun onLongClick(user: User, position: Int) = App.appContext.toastShort("onLongClick: ${user.name}")
        }, searchTheme)

    userAdapter.submitList(userList)
    return userAdapter
}