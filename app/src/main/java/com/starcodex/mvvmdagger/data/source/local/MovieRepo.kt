package com.starcodex.mvvmdagger.data.source.local

import io.reactivex.Flowable
import io.reactivex.Observable
import io.realm.Sort

/**
 * Created by Bonestack on 25/09/2018.
 */
interface MovieRepo {
    val movieChangeObservable: Observable<ArrayList<MovieItem>>

    fun findAllSorted(sortField: String?, sort: Sort, detached: Boolean): List<MovieItem>
    fun findAllSortedWithChanges(sortField: String?, sort: Sort): Flowable<List<MovieItem>>

    fun getByField(field: String?, value: String?, detached: Boolean): MovieItem?

    fun save(movie: MovieItem)

    fun saveCollection(movies: List<MovieItem>)
}