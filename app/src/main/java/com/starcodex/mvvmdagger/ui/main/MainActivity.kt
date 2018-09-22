package com.starcodex.mvvmdagger.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.starcodex.mvvmdagger.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
    }


    fun initRecycler(){

    }
}
