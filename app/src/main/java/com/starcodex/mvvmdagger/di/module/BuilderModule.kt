package com.starcodex.mvvmdagger.di.module

import com.starcodex.mvvmdagger.di.component.MainActivityComponent
import com.starcodex.mvvmdagger.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}