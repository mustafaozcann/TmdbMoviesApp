package com.mzcn.tmdbmoviesapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mzcn.tmdbmoviesapp.data.Resource
import com.mzcn.tmdbmoviesapp.data.models.Movie
import com.mzcn.tmdbmoviesapp.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {

    val movies: MutableLiveData<List<Movie>?> = MutableLiveData()

    init {
        viewModelScope.launch {

            val result = repository.getPopularMovies()

            if (result is Resource.Success) {
                movies.value = result.result.results
            }
        }
    }
}