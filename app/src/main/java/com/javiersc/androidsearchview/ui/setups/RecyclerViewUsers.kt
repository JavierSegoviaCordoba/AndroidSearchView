package com.javiersc.androidsearchview.ui.setups

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.androidsearchview.App
import com.javiersc.androidsearchview.model.User
import com.javiersc.androidsearchview.ui.adapter.UserAdapter
import com.javiersc.androidsearchview.ui.dummy.Lists
import com.javiersc.androidsearchview.ui.extension.toastShort
import com.javiersc.materialsearchview.constants.SearchTheme


fun setupRecyclerView(recyclerView: RecyclerView, searchTheme: SearchTheme) {
    recyclerView.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = setupUserAdapter(Lists.USERS, searchTheme)
    }
}

private fun setupUserAdapter(
    userList: List<User>,
    searchTheme: SearchTheme
): ListAdapter<User, UserAdapter.UserViewHolder> {
    val userAdapter = UserAdapter().apply {
        onClick = { user, position -> App.appContext.toastShort("onClick $position: ${user.name}") }
        onLongClick = { user, position -> App.appContext.toastShort("onLongClick $position: ${user.name}") }
        this.searchTheme = searchTheme
    }

    userAdapter.submitList(userList)
    return userAdapter
}