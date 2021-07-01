package com.android.academy.fundamentals.homework.data.remote.room

import com.android.academy.fundamentals.homework.data.remote.LocalDataSource
import com.android.academy.fundamentals.homework.model.Movie
import com.android.academy.fundamentals.homework.model.MovieDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(private val movieDb: AppDataBase) : LocalDataSource {

    override suspend fun loadMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            movieDb.movies.getAllMovie()
        }
    }

    override fun insertMovies(movieFromNetwork: List<Movie>) {
        movieDb.movies.insertMovie(movieFromNetwork)
    }

    override suspend fun loadMovie(movieId: Int): MovieDetails {
        return MovieDetails(1,1,"1", emptyList(), 1, true, 1, "1", "1", emptyList())
    }

    override fun insertMovieDetails(movieDetailsFromNetwork: Movie) {

    }

}