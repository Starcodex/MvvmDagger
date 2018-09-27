package com.starcodex.mvvmdagger.ui.main


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.databinding.MoviesListBinding
import dagger.android.AndroidInjection
import javax.inject.Inject
import com.starcodex.mvvmdagger.ui.BaseActivity
import com.starcodex.mvvmdagger.util.SchedulerProvider



class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var schedulerProvider:SchedulerProvider



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val binding: MoviesListBinding = DataBindingUtil.setContentView(this, R.layout.movies_list)
        initRecycler(mainViewModel,binding)
        initViewModel(mainViewModel)

    }


    fun initRecycler(mainViewModel: MainViewModel,binding: MoviesListBinding){
        binding.moviesViewModel = mainViewModel
        binding.moviesReycler.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        binding.moviesReycler.setLayoutManager(LinearLayoutManager(this))
        binding.moviesReycler.adapter = mainViewModel.moviesAdapter

    }

    fun initViewModel(mainViewModel: MainViewModel){
        mainViewModel.initViewModel(this)
        //mainViewModel.getMoviesList(35,getString(R.string.api_key))

    }

}
