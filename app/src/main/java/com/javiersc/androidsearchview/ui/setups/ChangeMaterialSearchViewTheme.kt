package com.javiersc.androidsearchview.ui.setups

import android.app.Activity
import android.graphics.PorterDuff
import android.os.Build
import android.view.Menu
import android.view.View
import androidx.core.view.forEach
import com.javiersc.androidsearchview.R
import com.javiersc.androidsearchview.ui.adapter.SuggestionAdapter
import com.javiersc.androidsearchview.ui.extension.colorize
import com.javiersc.materialsearchview.MaterialSearchView
import com.javiersc.materialsearchview.constants.SearchTheme
import com.javiersc.materialsearchview.extensions.color
import kotlinx.android.synthetic.main.activity_main.*


fun <T> Activity.changeMaterialSearchViewTheme(
    theme: SearchTheme,
    materialSearchView: MaterialSearchView<T>,
    menu: Menu?,
    suggestionAdapter: SuggestionAdapter
) = with(materialSearchView) {
    if (theme != SearchTheme.DARK) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            colorize(color(R.color.appBarLayoutDark), color(R.color.appBarLayoutLight)) { color ->
                window.statusBarColor = color
            }
        }

        colorize(color(R.color.backgroundParentDark), color(R.color.backgroundParentLight)) { color ->
            constrainLayoutParent.setBackgroundColor(color)
        }

        menu?.forEach {
            colorize(color(R.color.searchTextDark), color(R.color.searchTextLight)) { color ->
                it.icon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
            }
        }

        colorize(color(R.color.appBarLayoutDark), color(R.color.appBarLayoutLight)) { color ->
            toolbar.setBackgroundColor(color)
        }

        colorize(color(R.color.searchTextDark), color(R.color.searchTextLight)) { color ->
            toolbar.setTitleTextColor(color)
        }

        suggestionAdapter.apply {
            searchTheme = SearchTheme.LIGHT
        }

        searchTheme = SearchTheme.LIGHT
        setupRecyclerView(recyclerViewUsers, SearchTheme.LIGHT)

    } else {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) window.decorView.systemUiVisibility = 0

        colorize(color(R.color.appBarLayoutLight), color(R.color.appBarLayoutDark)) { color ->
            window.statusBarColor = color
        }

        colorize(color(R.color.backgroundParentLight), color(R.color.backgroundParentDark)) { color ->
            constrainLayoutParent.setBackgroundColor(color)
        }

        menu?.forEach {
            colorize(color(R.color.searchTextLight), color(R.color.searchTextDark)) { color ->
                it.icon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
            }
        }

        colorize(color(R.color.appBarLayoutLight), color(R.color.appBarLayoutDark)) { color ->
            toolbar.setBackgroundColor(color)
        }

        colorize(color(R.color.searchTextLight), color(R.color.searchTextDark)) { color ->
            toolbar.setTitleTextColor(color)
        }

        suggestionAdapter.apply {
            searchTheme = SearchTheme.DARK
        }

        searchTheme = SearchTheme.DARK
        setupRecyclerView(recyclerViewUsers, SearchTheme.DARK)

    }

}