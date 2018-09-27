package com.starcodex.mvvmdagger.component

import com.starcodex.mvvmdagger.di.module.MainActivityModule
import com.starcodex.mvvmdagger.module.MainActivityModuleTest
import com.starcodex.mvvmdagger.ui.list.MovieRowViewModel
import com.starcodex.mvvmdagger.ui.list.MoviesAdapter
import com.starcodex.mvvmdagger.ui.main.MainActivity
import com.starcodex.mvvmdagger.ui.main.MainViewModel
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Bonestack on 25/09/2018.
 */
@Subcomponent(modules = arrayOf(MainActivityModuleTest::class))
interface MainActivityComponentTest : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}