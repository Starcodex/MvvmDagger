package com.starcodex.mvvmdagger.ui.list

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.data.source.local.MovieItem
import com.starcodex.mvvmdagger.ui.detail.DetailActivity
import com.starcodex.mvvmdagger.ui.main.MainActivity
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class MovieRowViewModel @Inject
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
        get() = context.getString(R.string.movie_img)+movie!!.poster_path!!


    object ImageBindingAdapter {
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageUrl(view: ImageView, url: String) {
            Glide.with(view.getContext())
                    .load(url)
                    .into(view)
        }
    }

    fun onItemClick(view: View) {
        DetailActivity.navigate(context as MainActivity, view.findViewById(R.id.preview_poster), this!!.movie!!)
        Toast.makeText(context,movie!!.title, Toast.LENGTH_SHORT).show()
    }

}