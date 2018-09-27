package com.starcodex.mvvmdagger.module

import android.app.Application
import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.local.RealmMovieRepository
import com.starcodex.mvvmdagger.ui.list.MovieRowViewModel
import com.starcodex.mvvmdagger.ui.list.MoviesAdapter
import com.starcodex.mvvmdagger.ui.main.MainActivity
import com.starcodex.mvvmdagger.ui.main.MainViewModel
import com.starcodex.mvvmdagger.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm
import javax.inject.Provider

/**
 * Created by Bonestack on 25/09/2018.
 */
@Module
open class MainActivityModuleTest{

    @Provides
    open fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides open fun provideMovieRowViewModel(activity: Application): MovieRowViewModel {
        return MovieRowViewModel(activity)
    }

    @Provides
    open fun provideMoviesAdapter(activity: Application): MoviesAdapter = MoviesAdapter(activity)

    @Provides open fun provideMainViewModel(movieRepository: MovieRepository, moviesAdapter: MoviesAdapter,schedulerProvider: SchedulerProvider,realm:Realm): MainViewModel {
        return MainViewModel(movieRepository,moviesAdapter,schedulerProvider, RealmMovieRepository(Provider { realm }))
    }


}