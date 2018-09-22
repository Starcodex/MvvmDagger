package com.starcodex.mvvmdagger.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class MainViewModelFactory @Inject constructor(
        private val mainViewModel: MainViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java!!)) {
            return mainViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}