package com.starcodex.mvvmdagger.di.component

import com.starcodex.mvvmdagger.BaseApp
import com.starcodex.mvvmdagger.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Bonestack on 22/09/2018.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,AppModule::class))
interface AppComponent {
    fun inject(app: BaseApp)
}