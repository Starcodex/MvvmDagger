package com.starcodex.mvvmdagger.di.module

import com.starcodex.mvvmdagger.ui.main.MainActivity
import com.starcodex.mvvmdagger.ui.main.MovieRowViewModel
import com.starcodex.mvvmdagger.ui.main.MoviesAdapter
import dagger.Module
import dagger.Provides
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

    @Provides fun provideMovieRowViewModel(activity: MainActivity): MovieRowViewModel {
        return MovieRowViewModel(activity)
    }

    @Provides
    fun provideMoviesAdapter(activity: MainActivity): MoviesAdapter = MoviesAdapter(activity)

}