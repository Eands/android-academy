package com.android.academy.fundamentals.homework.data.remote.room.entities

import androidx.room.Entity
import com.android.academy.fundamentals.homework.model.Genre

@Entity(
    tableName = "Movie",
    primaryKeys = ["id"]
)
data class MovieEntity (
    val id: Int,
    val pgAge: Int,
    val title: String,
    val genres: List<Genre>,
    val runningTime: Int,
    val reviewCount: Int,
    val isLiked: Boolean,
    val rating: Int,
    val imageUrl: String?
)