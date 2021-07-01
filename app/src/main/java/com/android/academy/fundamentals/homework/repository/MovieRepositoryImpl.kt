package com.android.academy.fundamentals.homework.repository

import com.android.academy.fundamentals.homework.common.model.Result
import com.android.academy.fundamentals.homework.common.model.runCatchingResult
import com.android.academy.fundamentals.homework.data.locale.LocalDataSource
import com.android.academy.fundamentals.homework.data.remote.RemoteDataSource
import com.android.academy.fundamentals.homework.domain.MovieRepository
import com.android.academy.fundamentals.homework.model.Movie
import com.android.academy.fundamentals.homework.model.MovieDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class MovieRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {

    override suspend fun loadMovies(): Result<List<Movie>> {
        return runCatchingResult {  withContext(Dispatchers.IO) {
            val movieDB = localDataSource.loadMovies()
            movieDB.ifEmpty {
                val movieFromNetwork = remoteDataSource.loadMovies()
                localDataSource.insertMovies(movieFromNetwork)
                movieFromNetwork
            }
        }
        }
    }

    override suspend fun loadMovie(movieId: Int): Result<MovieDetails> {
        return runCatchingResult { remoteDataSource.loadMovie(movieId) }
    }
}