package com.starcodex.mvvmdagger.di.component

import com.starcodex.mvvmdagger.BaseApp
import com.starcodex.mvvmdagger.data.source.local.MovieRepo
import com.starcodex.mvvmdagger.di.module.AppModule
import com.starcodex.mvvmdagger.di.module.BuilderModule
import com.starcodex.mvvmdagger.di.module.DataModule
import com.starcodex.mvvmdagger.di.module.network.NetModule
import dagger.Component
import javax.inject.Singleton
import dagger.android.support.AndroidSupportInjectionModule
import io.realm.Realm


/**
 * Created by Bonestack on 22/09/2018.
 */

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, BuilderModule::class, NetModule::class, DataModule::class,AppModule::class))
interface AppComponent {
    //fun movieRepo(): MovieRepo
    fun inject(app: BaseApp)
    fun realm(): Realm
}
