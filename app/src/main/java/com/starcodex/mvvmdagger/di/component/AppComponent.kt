package com.starcodex.mvvmdagger.di.component

import com.starcodex.mvvmdagger.BaseApp
import com.starcodex.mvvmdagger.di.module.AppModule
import com.starcodex.mvvmdagger.di.module.BuilderModule
import com.starcodex.mvvmdagger.di.module.network.NetModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Bonestack on 22/09/2018.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, BuilderModule::class, NetModule::class,AppModule::class))
interface AppComponent {
    fun inject(app: BaseApp)
}