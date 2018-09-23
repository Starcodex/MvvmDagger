package com.starcodex.mvvmdagger.ui.main

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.data.source.local.MovieItem
import com.starcodex.mvvmdagger.databinding.MovieRowBinding
import com.starcodex.mvvmdagger.widget.ArrayRecyclerAdapter
import com.starcodex.mvvmdagger.widget.BindableHolder
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class MoviesAdapter @Inject
constructor(context: Context) : ArrayRecyclerAdapter<MovieItem, BindableHolder<MovieRowBinding>>(context) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableHolder<MovieRowBinding> {
        return BindableHolder(context, parent, R.layout.movie_row)
    }

    override fun onBindViewHolder(holder: BindableHolder<MovieRowBinding>, position: Int) {
        val movie = getItem(position)
        val row = holder.binding
        val movieRowViewModel = MovieRowViewModel(context)
        movieRowViewModel.bindMovie(movie!!)
        row.movieViewModel = movieRowViewModel
    }

}
