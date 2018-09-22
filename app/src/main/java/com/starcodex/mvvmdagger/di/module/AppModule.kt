package com.starcodex.mvvmdagger.di.module

import android.app.Application
import android.content.Context
import com.starcodex.mvvmdagger.di.component.MainActivityComponent
import com.starcodex.mvvmdagger.ui.main.MoviesAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
class AppModule(val app: Application){

    @Provides
    @Singleton
    fun provideApplication(): Application = app

}