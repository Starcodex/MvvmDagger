package com.starcodex.mvvmdagger.di.module

import com.starcodex.mvvmdagger.data.source.local.MovieRepo
import com.starcodex.mvvmdagger.data.source.local.RealmMovieRepository
import dagger.Binds
import dagger.Module

/**
 * Created by Bonestack on 26/09/2018.
 */
@Module
abstract class DataModule {

    @Binds
    internal abstract fun bindMovieRepo(realmMovieRepository: RealmMovieRepository): MovieRepo


}