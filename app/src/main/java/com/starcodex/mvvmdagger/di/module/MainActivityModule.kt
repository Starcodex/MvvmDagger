package com.starcodex.mvvmdagger.di.module

import android.app.Application
import android.content.Context
import com.starcodex.mvvmdagger.ui.main.MainActivity
import com.starcodex.mvvmdagger.ui.main.MoviesAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import io.reactivex.disposables.CompositeDisposable





/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
class MainActivityModule{

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideMoviesAdapter(activity: MainActivity): MoviesAdapter = MoviesAdapter(activity)

}