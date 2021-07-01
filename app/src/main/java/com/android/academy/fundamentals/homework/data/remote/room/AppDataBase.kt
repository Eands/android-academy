package com.android.academy.fundamentals.homework.data.remote.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.academy.fundamentals.homework.data.remote.room.daos.MovieDao
import com.android.academy.fundamentals.homework.data.remote.room.entities.ActorEntity
import com.android.academy.fundamentals.homework.data.remote.room.entities.GenreEntity
import com.android.academy.fundamentals.homework.data.remote.room.entities.MovieDetailsEntity
import com.android.academy.fundamentals.homework.data.remote.room.entities.MovieEntity

@Database(
    entities = [MovieEntity::class, MovieDetailsEntity::class, ActorEntity::class, GenreEntity::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract val movies : MovieDao

    companion object {
        private val DATABASE_NAME: String = "Movies.db"

        fun create(application: Context): AppDataBase {
            return Room.databaseBuilder(
                application,
                AppDataBase::class.java,
                DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}