package com.starcodex.mvvmdagger.data.source.local

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.realm.Realm
import io.realm.Sort
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Bonestack on 25/09/2018.
 */
class RealmMovieRepository
@Inject
constructor(private val realmProvider: Provider<Realm>) : MovieRepo {



    private val realmChangeCollection = PublishSubject.create<ArrayList<MovieItem>>()
    override val movieChangeObservable: Observable<ArrayList<MovieItem>>
        get() = realmChangeCollection

    override fun findAllSorted(sortField: String?, sort: Sort, detached: Boolean): List<MovieItem> {
        realmProvider.get().use { realm ->
            val realmResults = realm.where(MovieItem::class.java).findAllSorted(sortField, sort)

            if (detached) {
                return realm.copyFromRealm(realmResults)
            } else {
                return realmResults
            }
        }
    }

    override fun findAllSortedWithChanges(sortField: String?, sort: Sort): Flowable<List<MovieItem>> {
        realmProvider.get().use { realm ->
            return realm.where(MovieItem::class.java).findAllSortedAsync(sortField, sort).asFlowable()
                    .filter{ it.isLoaded }
                    .map { it }
        }
    }

    override fun getByField(field: String?, value: String?, detached: Boolean): MovieItem? {
        realmProvider.get().use { realm ->
            var realmCountry: MovieItem? = realm.where(MovieItem::class.java).equalTo(field, value).findFirst()
            if (detached && realmCountry != null) {
                realmCountry = realm.copyFromRealm<MovieItem>(realmCountry)
            }
            return realmCountry
        }
    }

    override fun save(movie: MovieItem) {
        realmProvider.get().use { realm ->
            realm.executeTransaction { r -> r.copyToRealmOrUpdate(movie) }
        }
    }

    override fun saveCollection(movies: List<MovieItem>) {
        realmProvider.get().use { realm ->
            realm.executeTransaction { r -> r.copyToRealmOrUpdate(movies) }
            realmChangeCollection.onNext(movies as ArrayList<MovieItem>)
        }
    }

}