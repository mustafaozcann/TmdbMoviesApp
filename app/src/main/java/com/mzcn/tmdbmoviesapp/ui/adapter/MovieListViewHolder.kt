package com.mzcn.tmdbmoviesapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mzcn.tmdbmoviesapp.data.models.Movie
import com.mzcn.tmdbmoviesapp.databinding.ItemMovieListBinding

class MovieListViewHolder(private val binding: ItemMovieListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.tvMovieTitle.text = movie.title
    }
}