package com.starcodex.mvvmdagger.di.module.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
//import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.local.RealmMovieRepository
import com.starcodex.mvvmdagger.data.source.remote.ApiInterface
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.realm.Realm
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
open class NetModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()


    @Provides
    @Singleton
    internal fun provideGsonConverterFactory() : GsonConverterFactory {
        val GSON = GsonBuilder()
                .registerTypeAdapterFactory(AutoValueAdapterFactory())
                .create()
        return GsonConverterFactory.create(GSON)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient,
                                 converterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }




    @Provides
    @Singleton
    open fun providesApiInterface(retrofit: Retrofit): ApiInterface = retrofit.create(
            ApiInterface::class.java)


}