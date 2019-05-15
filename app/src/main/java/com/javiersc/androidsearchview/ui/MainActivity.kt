package com.javiersc.androidsearchview.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.javiersc.androidsearchview.R
import com.javiersc.androidsearchview.model.User
import com.javiersc.androidsearchview.ui.adapter.SuggestionAdapter
import com.javiersc.androidsearchview.ui.dummy.Lists
import com.javiersc.androidsearchview.ui.extension.toastShort
import com.javiersc.androidsearchview.ui.setups.setupRecyclerView
import com.javiersc.searchtheme.SearchTheme
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        //startActivity(Intent(this, CollapsingActivity::class.java))

        @Suppress("UNCHECKED_CAST")
        val suggestionAdapter = SuggestionAdapter(object : SuggestionAdapter.OnClickListener {
            override fun onClick(user: User, position: Int) {
                toastShort("onClick: ${user.name}")
            }

            override fun onLongClick(user: User, position: Int) {
                toastShort("onClick: ${user.name}")
            }

        }, SearchTheme.LIGHT) as ListAdapter<Any?, RecyclerView.ViewHolder>


        with(materialSearchView) {
            onSearchTextChanged = { query -> println(query) }
            onSearchSubmit = { println(it) }
            onSearchSuggestionFilter = { query ->
                if (query.isEmpty()) suggestionAdapter.submitList(emptyList())
                else {
                    val list = Lists.USERS.filter { it.name.contains(query, ignoreCase = true) }
                    suggestionAdapter.submitList(list)
                }
            }
            searchSuggestionAdapter = suggestionAdapter
        }

        setupRecyclerView(recyclerViewUsers, SearchTheme.LIGHT)

        /*   menuMaterialSearchView.setAdapter(setupSuggestionAdapter(Lists.USERS, SearchTheme.LIGHT), Lists.SUGGESTIONS)

           menuMaterialSearchView.onQueryChanged = { query -> println(query) }
           menuMaterialSearchView.onSubmit = { query -> println(query) }

           menuMaterialSearchView.changeSearchTheme(SearchTheme.DARK)

           menuMaterialSearchView.searchTheme = SearchTheme.LIGHT*/
    }


/*
    private fun setupSuggestionAdapter(
        userList: List<User>,
        searchTheme: SearchTheme
    ): ListAdapter<User, SuggestionAdapter.SuggestionViewHolder> {
        val suggestionAdapter: ListAdapter<User, SuggestionAdapter.SuggestionViewHolder> =
            SuggestionAdapter(object : SuggestionAdapter.OnClickListener {
                override fun onClick(user: User, position: Int) {
                    toastShort("onClick: SmoothScrolling to ${user.name}")
                    recyclerViewItems.smoothSnapToPosition(userList.indexOf(user))
                    menuMaterialSearchView.close()
                }

                override fun onLongClick(user: User, position: Int) {
                    toastShort("onLongClick: ${user.name}")
                }
            }, searchTheme)

        suggestionAdapter.submitList(userList)
        return suggestionAdapter
    }

    private var isDarkTheme = false
    private fun changeMaterialSearchViewStyle(materialSearchView: MenuMaterialSearchView) = with(materialSearchView) {
        if (isDarkTheme) {
            constrainLayoutParent.setBackgroundColor(context.color(R.color.backgroundParentLight))
            recyclerViewItems.adapter = setupUserAdapter(Lists.USERS, SearchTheme.LIGHT)
            menuMaterialSearchView.setAdapter(setupSuggestionAdapter(Lists.USERS, SearchTheme.LIGHT), Lists.SUGGESTIONS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = context.color(R.color.appBarLayoutLight)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            for (i in 0 until menu.size()) {
                menu[i].icon.setColorFilter(context.color(R.color.searchTextLight), PorterDuff.Mode.SRC_ATOP)
            }
            toolbar.setBackgroundColor(context.color(R.color.appBarLayoutLight))
            toolbar.setTitleTextColor(context.color(R.color.searchTextLight))
            changeSearchTheme(SearchTheme.LIGHT)
            changeSearchTextColor(context.color(R.color.searchTextLight))
            changeSearchTextHintColor(context.color(R.color.searchTextHintLight))
            changeSearchBackgroundColor(context.color(R.color.backgroundLight))
            changeSearchBackgroundRippleColor(context.color(R.color.backgroundRippleLight))
            changeSearchCardBackgroundColor(context.color(R.color.searchCardBackgroundLight))
            changeSearchCardUpIconColor(context.color(R.color.searchUpIconLight))
            changeSearchSuggestionCardBackgroundColor(context.color(R.color.suggestionCardBackgroundLight))
            isDarkTheme = false
        } else {
            constrainLayoutParent.setBackgroundColor(context.color(R.color.backgroundParentDark))
            recyclerViewItems.adapter = setupUserAdapter(Lists.USERS, SearchTheme.DARK)
            menuMaterialSearchView.setAdapter(setupSuggestionAdapter(Lists.USERS, SearchTheme.DARK), Lists.SUGGESTIONS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = context.color(R.color.appBarLayoutDark)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = 0
            }
            for (i in 0 until menu.size()) {
                menu[i].icon.setColorFilter(context.color(R.color.searchTextDark), PorterDuff.Mode.SRC_ATOP)
            }
            toolbar.setBackgroundColor(context.color(R.color.appBarLayoutDark))
            toolbar.setTitleTextColor(context.color(R.color.searchTextDark))
            changeSearchTheme(SearchTheme.DARK)
            changeSearchTextColor(context.color(R.color.searchTextDark))
            changeSearchTextHintColor(context.color(R.color.searchTextHintDark))
            changeSearchBackgroundColor(context.color(R.color.backgroundDark))
            changeSearchBackgroundRippleColor(context.color(R.color.backgroundRippleDark))
            changeSearchCardBackgroundColor(context.color(R.color.searchCardBackgroundDark))
            changeSearchCardUpIconColor(context.color(R.color.searchUpIconDark))
            changeSearchSuggestionCardBackgroundColor(context.color(R.color.suggestionCardBackgroundDark))
            isDarkTheme = true
        }

    }


 */

    private lateinit var menu: Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        this.menu = menu
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.search -> {
            }//menuMaterialSearchView.open()
            R.id.changeTheme -> {
            }//changeMaterialSearchViewStyle(menuMaterialSearchView)
        }
        return super.onOptionsItemSelected(item)
    }

}

