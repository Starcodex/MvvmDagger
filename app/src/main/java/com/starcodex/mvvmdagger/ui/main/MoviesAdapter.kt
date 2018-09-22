package com.starcodex.mvvmdagger.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.data.Movie
import com.starcodex.mvvmdagger.ui.main.MoviesAdapter.MovieViewHolder
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class MoviesAdapter @Inject constructor() : RecyclerView.Adapter<MovieViewHolder>() {


    private var moviesList = ArrayList<Movie>()


    fun setList(movies: List<Movie>?){
        this.moviesList = movies as ArrayList<Movie>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.movie_row,
                parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieItem = moviesList[position]
        holder?.movieListItem(movieItem)
    }


    override fun getItemCount(): Int {
        return moviesList.size
    }


    fun addMovies(movies: List<Movie>){
        val initPosition = moviesList.size
        moviesList.addAll(movies)
        notifyItemRangeInserted(initPosition, moviesList.size)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun movieListItem(movieItem: Movie) {

        }
    }
}