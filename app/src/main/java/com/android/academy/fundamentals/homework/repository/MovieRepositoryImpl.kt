package com.android.academy.fundamentals.homework.repository

import com.android.academy.fundamentals.homework.data.remote.LocalDataSource
import com.android.academy.fundamentals.homework.data.remote.RemoteDataSource
import com.android.academy.fundamentals.homework.model.Movie
import com.android.academy.fundamentals.homework.model.MovieDetails

class MovieRepositoryImpl(
    private val remoteDataResource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): MovieRepository {

    override suspend fun loadMovies(): List<Movie> {
        var movies = remoteDataResource.loadMovies()
        if (movies.isEmpty()) {
            movies = localDataSource.loadMovies()
        } else {
            localDataSource.insertMovies(movies)
        }
        return movies
    }

    override suspend fun loadMovie(movieId: Int): MovieDetails {
        return remoteDataResource.loadMovie(movieId)
    }
}