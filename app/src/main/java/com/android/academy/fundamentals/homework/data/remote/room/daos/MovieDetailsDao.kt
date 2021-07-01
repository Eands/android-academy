package com.android.academy.fundamentals.homework.data.remote.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.academy.fundamentals.homework.data.remote.room.entities.MovieDetailsEntity
import com.android.academy.fundamentals.homework.model.MovieDetails

@Dao
interface MovieDetailsDao {

    @Query("Select * from MovieDetails")
    fun getMovieDetails() : MovieDetails

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetails(item: MovieDetailsEntity)
}