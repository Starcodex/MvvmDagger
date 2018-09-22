package com.starcodex.mvvmdagger.di.component

import com.starcodex.mvvmdagger.di.module.MainActivityModule
import com.starcodex.mvvmdagger.ui.main.MainActivity
import dagger.android.AndroidInjector
import dagger.Subcomponent



/**
 * Created by Bonestack on 22/09/2018.
 */
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}