package com.android.academy.fundamentals.homework.features.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.academy.fundamentals.homework.data.MovieRepository
import com.android.academy.fundamentals.homework.model.Movie
import kotlinx.coroutines.launch

class MoviesListViewModel(private val repository: MovieRepository) : ViewModel() {
    private val mutableMoviesList = MutableLiveData<List<Movie>>(emptyList())
    val movies : LiveData<List<Movie>> get() = mutableMoviesList

    fun addView() {
        viewModelScope.launch {
            val loadedMovies = repository.loadMovies()
            val updatedMoviesList = mutableMoviesList.value?.plus(loadedMovies).orEmpty()
            mutableMoviesList.value = updatedMoviesList
        }
    }
}