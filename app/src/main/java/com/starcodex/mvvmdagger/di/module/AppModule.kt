package com.starcodex.mvvmdagger.di.module

import android.app.Application
import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.local.MovieRepo
import com.starcodex.mvvmdagger.data.source.local.RealmMovieRepository
import com.starcodex.mvvmdagger.data.source.remote.ApiInterface
import com.starcodex.mvvmdagger.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
open class AppModule(val app: Application){

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProvider(Schedulers.io(), AndroidSchedulers.mainThread())

    @Provides
    @Singleton
    open fun provideApplication(): Application = app

    @Provides
    open fun provideRealm(): Realm = Realm.getDefaultInstance()

    //@Provides
    //open fun provideRealmMovieRepository(realm : Provider<Realm>) = RealmMovieRepository(realm)

    @Provides
    open fun provideMovieRepository(movieRepo: MovieRepo,apiInterface: ApiInterface)= MovieRepository(apiInterface)


}