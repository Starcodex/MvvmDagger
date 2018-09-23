package com.starcodex.mvvmdagger.ui.main

import android.arch.lifecycle.ViewModel
import android.util.Log

import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.local.MovieItem
import com.starcodex.mvvmdagger.data.source.remote.response.MoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmResults
import io.realm.kotlin.where
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by Bonestack on 22/09/2018.
 */

class MainViewModel @Inject constructor(private var movieRepository: MovieRepository, private var realm : Realm) : ViewModel() {

    @Inject lateinit var moviesAdapter: MoviesAdapter
    var results: RealmResults<MovieItem>? = null

    fun loadMovies(genre: Int, apikey: String ) {

        movieRepository.apiInterface.getMoviesList(genre, apikey)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(400, TimeUnit.MILLISECONDS)
                .subscribe()

    }

    fun fetchMoviesList(genre:Int,apikey:String) {

        movieRepository.apiInterface.getMoviesList(genre, apikey)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(400, TimeUnit.MILLISECONDS)
                .subscribe({
                    response ->

                    realm.beginTransaction()
                    realm.copyToRealmOrUpdate(response.results)
                    realm.commitTransaction()
                    Log.d("RESPONSE SUCCESS : ", response.results.toString())
                },{
                    error ->
                    Log.e("Error", error.message)
                })


        results = realm.where<MovieItem>().findAllAsync()
        results!!.addChangeListener({ element ->
            val objects = realm.copyFromRealm(element)
            moviesAdapter.reset(objects)
            moviesAdapter.notifyDataSetChanged()
        })

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