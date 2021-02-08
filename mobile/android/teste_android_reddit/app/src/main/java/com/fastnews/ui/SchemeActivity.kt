package com.fastnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

class SchemeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, ParentActivity::class.java))
        finish()
    }
}
