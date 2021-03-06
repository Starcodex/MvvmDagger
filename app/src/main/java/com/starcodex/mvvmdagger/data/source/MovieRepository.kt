package com.starcodex.mvvmdagger.data.source

import android.util.Log
import com.starcodex.mvvmdagger.data.Movie
import com.starcodex.mvvmdagger.data.source.local.MovieRepo
import com.starcodex.mvvmdagger.data.source.remote.ApiInterface
import com.starcodex.mvvmdagger.data.source.remote.response.MoviesResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class MovieRepository(val apiInterface: ApiInterface) {

    fun getMoviesFromApi(genre:Int,apikey:String)= apiInterface.getMoviesList(genre,apikey)


}
