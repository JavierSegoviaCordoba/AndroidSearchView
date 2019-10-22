package com.javiersc.androidsearchview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.javiersc.androidsearchview.R
import com.javiersc.androidsearchview.ui.setups.setupRecyclerView
import com.javiersc.materialsearchview.constants.SearchTheme
import com.javiersc.materialsearchview.extensions.color
import com.javiersc.materialsearchview.extensions.font
import kotlinx.android.synthetic.main.activity_collapsing.*

class CollapsingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing)

        setSupportActionBar(toolbar)
        collapsingToolbarLayout.apply {
            setCollapsedTitleTypeface(font(R.font.google_sans_medium))
            setExpandedTitleTypeface(font(R.font.google_sans_light))
            setExpandedTitleColor(color(R.color.white))
            setCollapsedTitleTextColor(color(R.color.white))
        }

        setupRecyclerView(recyclerViewUsers, SearchTheme.LIGHT)


    }

}
