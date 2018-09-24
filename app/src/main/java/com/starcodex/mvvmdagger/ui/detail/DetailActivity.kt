package com.starcodex.mvvmdagger.ui.detail

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.transition.Slide
import android.view.MenuItem
import android.view.View
import com.starcodex.mvvmdagger.R
import com.starcodex.mvvmdagger.data.source.local.MovieItem
import com.starcodex.mvvmdagger.databinding.MovieDetailBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Bonestack on 23/09/2018.
 */
class DetailActivity : AppCompatActivity() {


    companion object {

        private val EXTRA_MOVIE = "EXTRA_MOVIE"
        private val EXTRA_IMAGE = "EXTRA_IMAGE"

        fun navigate(activity: AppCompatActivity, transitionImage: View, movie: MovieItem) {

            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, movie)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_IMAGE)
            ActivityCompat.startActivity(activity, intent, options.toBundle())
        }
    }

    @Inject
    lateinit var detailViewModel : DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        detailViewModel.bindMovie(intent.getSerializableExtra(EXTRA_MOVIE) as MovieItem)
        val binding: MovieDetailBinding = DataBindingUtil.setContentView(this, R.layout.movie_detail)
        binding.movieViewModel = detailViewModel
        initActivityTransitions(binding)
        setActionBar(binding)

    }

    private fun initActivityTransitions(binding: MovieDetailBinding) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val transition = Slide()
            transition.excludeTarget(android.R.id.statusBarBackground, true)
            window.enterTransition = transition
            window.returnTransition = transition
        }

        ViewCompat.setTransitionName(binding.image, EXTRA_IMAGE)
    }


    private fun setActionBar(binding: MovieDetailBinding) {
        setSupportActionBar(binding.toolbar as Toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.collapsingToolbar.setExpandedTitleColor(resources.getColor(android.R.color.transparent))
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
