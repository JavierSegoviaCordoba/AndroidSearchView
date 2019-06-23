package com.javiersc.androidsearchview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.javiersc.androidsearchview.R
import com.javiersc.materialsearchview.extensions.color
import kotlinx.android.synthetic.main.activity_collapsing.*
import kotlinx.android.synthetic.main.activity_main.toolbar


class CollapsingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing)

        setSupportActionBar(toolbar)
        collapsingToolbarLayout.setExpandedTitleColor(this.color(R.color.white))
        collapsingToolbarLayout.setCollapsedTitleTextColor(this.color(R.color.white))
    }

}
