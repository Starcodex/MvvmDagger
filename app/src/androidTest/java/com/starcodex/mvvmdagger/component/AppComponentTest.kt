package com.starcodex.mvvmdagger.component

import com.starcodex.mvvmdagger.di.component.AppComponent
import com.starcodex.mvvmdagger.module.AppModuleTest
import com.starcodex.mvvmdagger.module.BuilderModuleTest
import com.starcodex.mvvmdagger.module.NetModuleTest
import com.starcodex.mvvmdagger.ui.main.MainTestExample
import com.starcodex.mvvmdagger.ui.main.MainViewModelTest
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Bonestack on 25/09/2018.
 */
@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, BuilderModuleTest::class, NetModuleTest::class, AppModuleTest::class))
interface AppComponentTest : AppComponent {
    fun inject(test: MainTestExample)
    fun inject(test: MainViewModelTest)
}