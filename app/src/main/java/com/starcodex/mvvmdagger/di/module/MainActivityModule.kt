package com.starcodex.mvvmdagger.di.module

import android.app.Activity
import android.app.Application
import android.content.Context
import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.local.MovieRepo
import com.starcodex.mvvmdagger.data.source.local.RealmMovieRepository
import com.starcodex.mvvmdagger.ui.main.MainActivity
import com.starcodex.mvvmdagger.ui.list.MovieRowViewModel
import com.starcodex.mvvmdagger.ui.list.MoviesAdapter
import com.starcodex.mvvmdagger.ui.main.MainViewModel
import com.starcodex.mvvmdagger.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm
import javax.inject.Provider

/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
open class MainActivityModule{

    @Provides
    open fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideContext(activity: MainActivity):Activity{
        return activity
    }

    @Provides open fun provideMovieRowViewModel(activity: Application): MovieRowViewModel {
        return MovieRowViewModel(activity)
    }

    @Provides
    open fun provideMoviesAdapter(activity: Application): MoviesAdapter = MoviesAdapter(activity)

    @Provides open fun provideMainViewModel(movieRepository: MovieRepository, moviesAdapter: MoviesAdapter,schedulerProvider: SchedulerProvider,realm:Realm): MainViewModel {
        return MainViewModel(movieRepository,moviesAdapter,schedulerProvider,RealmMovieRepository(Provider { realm }))
    }

}