package com.starcodex.mvvmdagger.ui.detail

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.data.source.local.MovieItem
import javax.inject.Inject

/**
 * Created by Bonestack on 23/09/2018.
 */
class DetailViewModel @Inject
constructor(private var context: Context) : BaseObservable() {

    var movie: MovieItem? = null

    fun bindMovie(movie: MovieItem) {
        this.movie = movie
    }

    val title: String
        get() = movie!!.title!!

    val overview: String
        get() = movie!!.overview!!

    val imageUrl: String
        get() = context.getString(R.string.movie_img_detail)+movie!!.poster_path!!


    object ImageBindingAdapter {
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageUrl(view: ImageView, url: String) {
            Glide.with(view.getContext())
                    .load(url)
                    .into(view)
        }
    }

}