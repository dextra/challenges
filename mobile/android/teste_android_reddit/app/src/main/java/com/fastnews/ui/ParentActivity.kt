package com.fastnews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ParentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.fastnews.R.layout.activity_parent)
    }

}
