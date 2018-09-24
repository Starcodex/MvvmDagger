package com.starcodex.mvvmdagger.di.component

import com.starcodex.mvvmdagger.di.module.DetailActivityModule
import com.starcodex.mvvmdagger.di.module.MainActivityModule
import com.starcodex.mvvmdagger.ui.detail.DetailActivity
import com.starcodex.mvvmdagger.ui.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Bonestack on 24/09/2018.
 */
@Subcomponent(modules = arrayOf(DetailActivityModule::class))
interface DetailActivityComponent : AndroidInjector<DetailActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetailActivity>()
}