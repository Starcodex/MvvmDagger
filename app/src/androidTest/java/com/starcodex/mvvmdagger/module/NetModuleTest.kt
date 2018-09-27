package com.starcodex.mvvmdagger.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.remote.ApiInterface
import com.starcodex.mvvmdagger.di.module.network.AutoValueAdapterFactory
import com.starcodex.mvvmdagger.di.module.network.NetModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.mockito.Mockito
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Bonestack on 25/09/2018.
 */
@Module
class NetModuleTest(private val baseUrl: String) {

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
     fun providesApiInterface(retrofit: Retrofit): ApiInterface = retrofit.create(
            ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideMovieRepository(apiInterface: ApiInterface)= MovieRepository(apiInterface)
}