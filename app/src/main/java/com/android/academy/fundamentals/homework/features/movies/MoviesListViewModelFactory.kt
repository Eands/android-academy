package com.android.academy.fundamentals.homework.features.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.academy.fundamentals.homework.data.MovieRepository

class MoviesListViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesListViewModel(repository) as T
    }
}