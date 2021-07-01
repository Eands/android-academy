package com.android.academy.fundamentals.homework.data.remote.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import java.io.Serializable

@Entity(
    tableName = "Actor",
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
data class ActorEntity(
    val parentId: Int,
    val id: Int,
    val name: String,
    val imageUrl: String?,
) : Serializable