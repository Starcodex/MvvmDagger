package com.starcodex.mvvmdagger.ui.main

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.util.Log
import com.starcodex.mvvmdagger.R

import com.starcodex.mvvmdagger.data.source.MovieRepository
import com.starcodex.mvvmdagger.data.source.local.MovieItem
import com.starcodex.mvvmdagger.data.source.local.MovieRepo
import com.starcodex.mvvmdagger.data.source.local.RealmMovieRepository
import com.starcodex.mvvmdagger.data.source.remote.response.MoviesResponse
import com.starcodex.mvvmdagger.ui.list.MoviesAdapter
import com.starcodex.mvvmdagger.util.SchedulerProvider
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.realm.*
import io.realm.kotlin.where
import io.realm.rx.CollectionChange
import org.reactivestreams.Subscription
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider
import kotlin.collections.ArrayList


/**
 * Created by Bonestack on 22/09/2018.
 */

class MainViewModel @Inject constructor(var movieRepository: MovieRepository, var moviesAdapter : MoviesAdapter, var schedulerProvider: SchedulerProvider,var realmMovieRepository : RealmMovieRepository) : ViewModel() {

    var TAG : String = javaClass.simpleName


    fun updateListUI(items: ArrayList<MovieItem>){
        moviesAdapter.reset(items)
        moviesAdapter.notifyDataSetChanged()
    }


    private val compositeDisposable by lazy { CompositeDisposable() }

    fun getMoviesList(genre:Int,apikey:String) =
        movieRepository.apiInterface.getMoviesList(genre, apikey)
                .compose(schedulerProvider.getSchedulersForObservable())


    fun findAllLocalMovies(realm : Realm)  = Observable.create({e: ObservableEmitter<ArrayList<MovieItem>> ->
        val movies = realm.where(MovieItem::class.java).findAll()
        if (movies.size > 0) {
            e.onNext(ArrayList<MovieItem>(realm.copyFromRealm(movies)))
            e.onComplete()
        } })



    fun addRealmObserver(){
        compositeDisposable.addAll(
                realmMovieRepository.movieChangeObservable.subscribe({
                    t: ArrayList<MovieItem>? ->
                    updateListUI(t!!)
                })
        )
    }

    fun initViewModel(context: Context){
        addRealmObserver()
        reloadData(context)
    }


    fun reloadData(context : Context){
        compositeDisposable.addAll(
                getMoviesList(35,context.getString(R.string.api_key))
                        .subscribe({t: MoviesResponse? ->
                            saveToRealmRepository( t!!.results as ArrayList<MovieItem>)
                            Log.d(TAG,"SAVED REALM RESULTS")
                        })
        )
    }

    fun saveToRealmRepository(arrayList: ArrayList<MovieItem>){
        realmMovieRepository.saveCollection(arrayList)
    }


}

