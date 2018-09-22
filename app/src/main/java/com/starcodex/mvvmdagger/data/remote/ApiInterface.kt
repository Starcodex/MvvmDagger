package com.starcodex.mvvmdagger.data.remote

import com.starcodex.mvvmdagger.data.Movie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Bonestack on 22/09/2018.
 */
interface ApiInterface {

    @GET("genre/{genre}/movies?api_key={apikey}")
    fun getMoviesList(@Path("genre") genre:Int, @Path("apikey") apikey:String): Observable<List<Movie>>
}