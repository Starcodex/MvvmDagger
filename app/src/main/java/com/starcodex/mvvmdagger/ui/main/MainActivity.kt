package com.starcodex.mvvmdagger.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.databinding.MoviesListBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel
    //lateinit var mainViewModelFactory: MainViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val binding: MoviesListBinding = DataBindingUtil.setContentView(this, R.layout.movies_list)
        //var mainViewModel: MainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)
        initRecycler(mainViewModel,binding)
        retieveMovies(mainViewModel)

    }


    fun initRecycler(mainViewModel: MainViewModel,binding: MoviesListBinding){
        binding.moviesViewModel = mainViewModel
        binding.moviesReycler.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        binding.moviesReycler.setLayoutManager(LinearLayoutManager(this))
        binding.moviesReycler.adapter = mainViewModel.moviesAdapter

    }

    fun retieveMovies(mainViewModel: MainViewModel){
        mainViewModel.fetchMoviesList(35,applicationContext.getString(R.string.api_key))
    }
}
