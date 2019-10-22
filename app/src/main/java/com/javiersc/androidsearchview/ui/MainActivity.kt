package com.javiersc.androidsearchview.ui

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.javiersc.androidsearchview.R
import com.javiersc.androidsearchview.ui.adapter.SuggestionAdapter
import com.javiersc.androidsearchview.ui.dummy.Lists
import com.javiersc.androidsearchview.ui.extension.toastShort
import com.javiersc.androidsearchview.ui.setups.changeMaterialSearchViewTheme
import com.javiersc.materialsearchview.constants.SearchTheme
import com.javiersc.materialsearchview.constants.SearchType
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var theme = SearchTheme.LIGHT

    private var menu: Menu? = null

    private val suggestionAdapter by lazy {
        SuggestionAdapter().apply {
            onClick = { user, position -> toastShort("onClick $position: ${user.name}") }
            onLongClick = { user, position -> toastShort("onLongClick $position: ${user.name}") }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let { theme = if (it.getInt("THEME") == 0) SearchTheme.LIGHT else SearchTheme.DARK }
        setSupportActionBar(toolbar)

        materialSearchView.apply {

            searchClearIconEnabled = true

            searchMicIconEnabled = true

            searchType = SearchType.MENU
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
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        this.menu = menu
        menuInflater.inflate(R.menu.main, menu)
        changeMaterialSearchViewTheme(theme, materialSearchView, menu, suggestionAdapter)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.collapsingActivity -> startActivity(Intent(this, CollapsingActivity::class.java))
            R.id.appBarActivity -> startActivity(Intent(this, AppBarActivity::class.java))
            R.id.changeTheme -> {
                theme = if (theme == SearchTheme.LIGHT) SearchTheme.DARK else SearchTheme.LIGHT
                changeMaterialSearchViewTheme(theme, materialSearchView, menu, suggestionAdapter)
            }
            R.id.search -> materialSearchView.apply {
                searchMenuItem = item
                open()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("THEME", theme.value)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 181) {
            materialSearchView.searchText = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.get(0) ?: ""
        }
    }
}

