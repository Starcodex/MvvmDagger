package com.starcodex.mvvmdagger.data.source

import android.util.Log
import com.starcodex.mvvmdagger.data.Movie
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
class MovieRepository @Inject constructor(val apiInterface: ApiInterface) {


    fun getMoviesFromApi(genre:Int,apikey:String){
        apiInterface.getMoviesByGenre(genre,apikey).enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
                Log.e("ERROR", "ERROR")
            }
            override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>?) {
                Log.d("MOVIES",response.toString())
            }
        })
    }


}
