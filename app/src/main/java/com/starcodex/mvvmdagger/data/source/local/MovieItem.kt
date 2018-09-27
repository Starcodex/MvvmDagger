package com.starcodex.mvvmdagger.data.source.local

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

/**
 * Created by Bonestack on 22/09/2018.
 */
open class MovieItem : RealmObject() , Serializable,Comparable<MovieItem>{
    override fun compareTo(other: MovieItem): Int {
        if (title != null && other.title != null) {
            return title!!.compareTo(other.title!!)
        } else {
            return 0
        }
    }


    @SerializedName("id")
    @Expose
    @PrimaryKey
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("overview")
    @Expose
    var overview: String? = null

    @SerializedName("poster_path")
    @Expose
    var poster_path: String? = null

}