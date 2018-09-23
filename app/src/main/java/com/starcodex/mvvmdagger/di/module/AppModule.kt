package com.starcodex.mvvmdagger.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Singleton

/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
class AppModule(val app: Application){

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideRealm(): Realm = Realm.getDefaultInstance()

}