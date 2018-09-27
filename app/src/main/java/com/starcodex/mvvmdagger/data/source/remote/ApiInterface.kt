package com.starcodex.mvvmdagger.data.source.remote

import com.starcodex.mvvmdagger.data.Movie
import com.starcodex.mvvmdagger.data.source.remote.response.MoviesResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Bonestack on 22/09/2018.
 */
interface ApiInterface {

    @GET("genre/{genre}/movies")
    fun getMoviesByGenre(@Path("genre") genre:Int, @Query("api_key") apikey:String): Call<MoviesResponse>

    @GET("genre/{genre}/movies")
    fun getMoviesList(@Path("genre") genre:Int, @Query("api_key") apikey:String): Observable<MoviesResponse>

}