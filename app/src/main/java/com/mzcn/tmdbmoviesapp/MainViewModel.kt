package com.mzcn.tmdbmoviesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mzcn.tmdbmoviesapp.data.Resource
import com.mzcn.tmdbmoviesapp.data.models.Movie
import com.mzcn.tmdbmoviesapp.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {

    private val _movies: MutableLiveData<List<Movie>?> = MutableLiveData()
    val movies: LiveData<List<Movie>?> = _movies

    init {
        viewModelScope.launch {
            repository.getPopularMovies()
                .collect { resource ->
                    when (resource) {
                        is Resource.Success -> {
                            Log.d("TAG", "SUCCESS")
                            _movies.value = resource.result.results
                        }
                        is Resource.Failure -> {

                        }
                        Resource.Loading ->{
                            Log.d("TAG", "LOADING")
                        }
                    }
                }
        }
    }
}