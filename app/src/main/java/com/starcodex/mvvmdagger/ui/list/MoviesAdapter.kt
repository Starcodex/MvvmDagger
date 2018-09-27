package com.starcodex.mvvmdagger.ui.list

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.ViewGroup
import com.starcodex.mvvmdagger.BaseApp
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.data.source.local.MovieItem
import com.starcodex.mvvmdagger.databinding.MovieRowBinding
import com.starcodex.mvvmdagger.ui.list.MovieRowViewModel
import com.starcodex.mvvmdagger.widget.ArrayRecyclerAdapter
import com.starcodex.mvvmdagger.widget.BindableHolder
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class MoviesAdapter @Inject
constructor(context: Application) : ArrayRecyclerAdapter<MovieItem, BindableHolder<MovieRowBinding>>(context) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableHolder<MovieRowBinding> {
        return BindableHolder(context, parent, R.layout.movie_row)
    }

    override fun onBindViewHolder(holder: BindableHolder<MovieRowBinding>, position: Int) {
        val movie = getItem(position)
        val row = holder.binding
        val movieRowViewModel = MovieRowViewModel(context as BaseApp)
        movieRowViewModel.bindMovie(movie!!)
        row.movieViewModel = movieRowViewModel
    }

}
