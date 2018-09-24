package com.starcodex.mvvmdagger.di.module

import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.ui.main.MainActivity
import com.starcodex.mvvmdagger.ui.list.MovieRowViewModel
import com.starcodex.mvvmdagger.ui.list.MoviesAdapter
import com.starcodex.mvvmdagger.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm

/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
class MainActivityModule{

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides fun provideMovieRowViewModel(activity: MainActivity): MovieRowViewModel {
        return MovieRowViewModel(activity)
    }

    @Provides
    fun provideMoviesAdapter(activity: MainActivity): MoviesAdapter = MoviesAdapter(activity)

    @Provides fun provideMainViewModel(movieRepository: MovieRepository, realm: Realm, moviesAdapter: MoviesAdapter): MainViewModel {
        return MainViewModel(movieRepository,realm,moviesAdapter)
    }

}