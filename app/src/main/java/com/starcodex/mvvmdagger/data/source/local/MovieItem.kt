package com.starcodex.mvvmdagger.data.source.local

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Bonestack on 22/09/2018.
 */
open class MovieItem : RealmObject() {

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