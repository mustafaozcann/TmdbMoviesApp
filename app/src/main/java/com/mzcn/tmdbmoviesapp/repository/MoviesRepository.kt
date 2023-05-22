package com.mzcn.tmdbmoviesapp.repository

import com.mzcn.tmdbmoviesapp.data.Resource
import com.mzcn.tmdbmoviesapp.data.models.PopularMovies

interface MoviesRepository {

    suspend fun getPopularMovies(): Resource<PopularMovies>

}