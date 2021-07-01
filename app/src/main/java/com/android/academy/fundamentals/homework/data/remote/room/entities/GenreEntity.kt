package com.android.academy.fundamentals.homework.data.remote.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "Genre",
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
data class GenreEntity(
    val parentId: Int,
    val id: Int,
    val name: String)