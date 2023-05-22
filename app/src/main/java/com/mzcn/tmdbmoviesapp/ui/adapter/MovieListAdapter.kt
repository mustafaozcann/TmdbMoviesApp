package com.mzcn.tmdbmoviesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mzcn.tmdbmoviesapp.data.models.Movie
import com.mzcn.tmdbmoviesapp.databinding.ItemMovieListBinding

class MovieListAdapter : ListAdapter<Movie, MovieListViewHolder>(MovieListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {

        return MovieListViewHolder(
            ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }
}