package com.mzcn.tmdbmoviesapp.repository

import com.mzcn.tmdbmoviesapp.data.Resource
import com.mzcn.tmdbmoviesapp.data.models.PopularMovies
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getPopularMovies(): Flow<Resource<PopularMovies>>

}