package com.starcodex.mvvmdagger.ui.detail

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.databinding.MoviesListBinding
import com.starcodex.mvvmdagger.ui.main.MainViewModel
import com.starcodex.mvvmdagger.ui.main.MainViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Bonestack on 23/09/2018.
 */
class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val binding: MoviesListBinding = DataBindingUtil.setContentView(this, R.layout.movies_list)
        mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(
                MainViewModel::class.java)

        initRecycler(binding)
    }


    fun initRecycler(binding: MoviesListBinding){
        binding.moviesViewModel = mainViewModel
        binding.moviesReycler.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        binding.moviesReycler.setLayoutManager(LinearLayoutManager(this))
        binding.moviesReycler.adapter = mainViewModel.moviesAdapter
        mainViewModel.fetchMoviesList(35,applicationContext.getString(R.string.api_key))
    }
}
