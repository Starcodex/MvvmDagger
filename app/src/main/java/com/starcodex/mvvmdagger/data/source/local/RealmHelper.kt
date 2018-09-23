package com.starcodex.mvvmdagger.data.source.local

import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults



/**
 * Created by Bonestack on 23/09/2018.
 */
class RealmHelper(internal var realm: Realm) {

    //WRITE
    fun save(obj: RealmObject) {
        realm.executeTransaction(object : Realm.Transaction {
            override fun execute(realm: Realm) {

                val s = realm.copyToRealm(obj)

            }
        })

    }

    //READ
 /*   fun retrieve(objectClass: RealmObject): ArrayList<String> {

        return ArrayList<>(realm.where(objectClass::class.java).findAll()).addAll()
    }*/
}