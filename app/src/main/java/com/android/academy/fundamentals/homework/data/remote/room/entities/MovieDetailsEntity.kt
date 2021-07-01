package com.android.academy.fundamentals.homework.data.remote.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "MovieDetails",
    primaryKeys = ["id"],
    foreignKeys = [
        ForeignKey(
            entity = MovieEntity::class,
            parentColumns = ["id"],
            childColumns = ["parentId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MovieDetailsEntity (
    val parentId: Int,
    val id: Int,
    val pgAge: Int,
    val title: String,
//    val genres: List<Genre>,
    val reviewCount: Int,
    val isLiked: Boolean,
    val rating: Int,
    val detailImageUrl: String?,
    val storyLine: String,
//    val actors: List<Actor>
)