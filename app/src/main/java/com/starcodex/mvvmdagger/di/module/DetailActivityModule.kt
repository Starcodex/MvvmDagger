package com.starcodex.mvvmdagger.di.module

import com.starcodex.mvvmdagger.ui.detail.DetailActivity
import com.starcodex.mvvmdagger.ui.detail.DetailViewModel
import com.starcodex.mvvmdagger.ui.list.MovieRowViewModel
import com.starcodex.mvvmdagger.ui.list.MoviesAdapter
import com.starcodex.mvvmdagger.ui.main.MainActivity
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Bonestack on 24/09/2018.
 */
@Module
class DetailActivityModule{

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides fun provideDetailViewModel(activity: DetailActivity): DetailViewModel {
        return DetailViewModel(activity)
    }

}