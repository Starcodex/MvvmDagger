package com.starcodex.mvvmdagger.module

import com.starcodex.mvvmdagger.di.module.DetailActivityModule
import com.starcodex.mvvmdagger.di.module.MainActivityModule
import com.starcodex.mvvmdagger.ui.detail.DetailActivity
import com.starcodex.mvvmdagger.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Bonestack on 25/09/2018.
 */
@Module
abstract class BuilderModuleTest {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModuleTest::class))
    abstract fun bindMainActivity(): MainActivity

}