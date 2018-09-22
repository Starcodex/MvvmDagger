package com.starcodex.mvvmdagger.di.module.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
//import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.starcodex.mvvmdagger.data.source.remote.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by Bonestack on 22/09/2018.
 */
@Module
class NetModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

/*    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()*/

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


    /*
    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder().client(okHttpClient).baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }*/

    @Provides
    @Singleton
    fun providesApiInterface(retrofit: Retrofit): ApiInterface = retrofit.create(
            ApiInterface::class.java)
}