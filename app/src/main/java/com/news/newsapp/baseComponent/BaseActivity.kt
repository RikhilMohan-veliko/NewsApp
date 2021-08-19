package com.news.newsapp.baseComponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.news.newsapp.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }


}