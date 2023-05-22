package com.mzcn.tmdbmoviesapp.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mzcn.tmdbmoviesapp.data.models.Movie

class MovieListDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = (oldItem == newItem)
}
