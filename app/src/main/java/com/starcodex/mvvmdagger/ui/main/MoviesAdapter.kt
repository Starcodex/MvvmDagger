package com.starcodex.mvvmdagger.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.data.Movie
import com.starcodex.mvvmdagger.ui.main.MoviesAdapter.MovieViewHolder
import kotlinx.android.synthetic.main.movie_row.view.*
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by Bonestack on 22/09/2018.
 */
class MoviesAdapter @Inject constructor(var context : Context) : RecyclerView.Adapter<MovieViewHolder>() {


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
        holder?.movieListItem(movieItem,context)
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


        fun movieListItem(movieItem: Movie, context: Context) {
            itemView.film_overview.text = movieItem.overview
            itemView.film_title.text = movieItem.title

            Glide.with(context)
                    .load(context.getString(R.string.movie_img)+movieItem.poster_path)
                    .apply(RequestOptions().placeholder(R.drawable.preview).error(R.drawable.preview))
                    .into(itemView.preview_poster)

        }
    }
}