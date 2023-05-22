package com.mzcn.tmdbmoviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mzcn.tmdbmoviesapp.databinding.ActivityMainBinding
import com.mzcn.tmdbmoviesapp.ui.adapter.MovieListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    private val movieListAdapter by lazy {
        MovieListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {

        rvMovies.adapter = movieListAdapter

        viewModel.movies.observe(this@MainActivity, Observer { movies ->

            movieListAdapter.submitList(movies)
        })
    }
}