package com.starcodex.mvvmdagger.ui.main

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.starcodex.mvvmdagger.data.Movie
import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.remote.response.MoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class MainViewModel @Inject constructor(private var movieRepository: MovieRepository) : ViewModel() {


    @Inject lateinit var movieAdapter : MoviesAdapter
    lateinit var disposableObserver: DisposableObserver<MoviesResponse>



    fun loadMovies(genre: Int, apikey: String ) {
        disposableObserver = object : DisposableObserver<MoviesResponse>() {
            override fun onComplete() {
                Log.d("","COMPLETE MOVIES")
            }

            override fun onNext(movies: MoviesResponse) {
                Log.d("",movies.toString())
            }

            override fun onError(e: Throwable) {
                Log.e("ERROR",e.message)
            }
        }

        movieRepository.apiInterface.getMoviesList(genre, apikey)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(400, TimeUnit.MILLISECONDS)
                .subscribe(disposableObserver)
    }


    fun getMoviesByGenre(genre: Int, apikey: String){
        movieRepository.apiInterface.getMoviesByGenre(genre,apikey).enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
                Log.e("ERROR","Response Error")
                Log.e("ERROR",t.toString())
            }
            override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>?) {
                Log.d("RESPONSE SUCCESS : ", response!!.body()!!.results.toString())
            }

        })
    }
}