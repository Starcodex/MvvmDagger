package com.starcodex.mvvmdagger.di.module

import com.starcodex.mvvmdagger.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}