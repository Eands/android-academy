package ru.self.appkotlin.data.models

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Movie(
    val id: Int,
    val pgAge: Int,
    val isLiked: Boolean,
    @DrawableRes val imageRes: Int,
    @DrawableRes val detailImageRes: Int,
    val genres: String,
    val title: String,
    val duration: String,
    val description: String,
    val stars: Int,
    val reviews: Int,
    val actors: List<Actor>
) : Serializable