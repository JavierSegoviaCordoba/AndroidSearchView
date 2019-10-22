package com.javiersc.androidsearchview.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.javiersc.androidsearchview.R
import com.javiersc.androidsearchview.material.constants.SearchTheme
import com.javiersc.androidsearchview.material.extensions.color
import com.javiersc.androidsearchview.ui.extension.colorize
import com.javiersc.androidsearchview.ui.setups.setupRecyclerView
import kotlinx.android.synthetic.main.activity_appbar.*

class AppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appbar)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

            colorize(color(R.color.appBarLayoutDark), color(R.color.statusBarWhiteTransparent)) { color ->
                window.statusBarColor = color
            }

        }

        setupRecyclerView(recyclerViewUsers, SearchTheme.LIGHT)
    }

}
