package com.android.academy.fundamentals.homework.data.remote.room.daos

import androidx.room.*
import com.android.academy.fundamentals.homework.data.remote.room.entities.MovieEntity
import com.android.academy.fundamentals.homework.model.Movie

@Dao
interface MovieDao {

    @Query("select * from Movie")
    fun getAllMovie() : List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(items: List<Movie>)
}