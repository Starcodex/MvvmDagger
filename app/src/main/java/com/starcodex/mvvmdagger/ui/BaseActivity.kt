package com.starcodex.mvvmdagger.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.starcodex.mvvmdagger.BaseApp


/**
 * Created by Bonestack on 25/09/2018.
 */
open class BaseActivity : AppCompatActivity() {
    protected lateinit var mMyApp: BaseApp

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMyApp = this.applicationContext as BaseApp
    }

    override fun onResume() {
        super.onResume()
        mMyApp.setCurrentActivity(this)
    }

    override fun onPause() {
        clearReferences()
        super.onPause()
    }

    override fun onDestroy() {
        clearReferences()
        super.onDestroy()
    }

    private fun clearReferences() {
        val currActivity = mMyApp.getCurrentActivity()
        if (this == currActivity)
            mMyApp.setCurrentActivity(null)
    }
}