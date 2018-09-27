package com.starcodex.mvvmdagger.module

import android.app.Application
import android.content.Context
import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.remote.ApiInterface
import com.starcodex.mvvmdagger.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import org.mockito.Mockito
import javax.inject.Singleton

/**
 * Created by Bonestack on 25/09/2018.
 */
@Module
open class AppModuleTest(val app: Application){

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProvider(Schedulers.io(), AndroidSchedulers.mainThread())

    @Provides
    @Singleton
    open fun provideApplication(): Application = app

    @Provides
    @Singleton
    open fun provideRealm(): Realm = Mockito.spy(Realm.getDefaultInstance())


    @Provides
    @Singleton
    open fun provideContext() : Context = app.applicationContext

}