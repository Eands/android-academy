package com.android.academy.fundamentals.homework.model

data class Movie(
    val id: Int,
    val adult: Boolean,
    val genre_ids: List<Genre>,
    val title: String,
    val poster_path: String,
    val overview: String,
    val backdrop_path: String,
    val vote_count: Int,
    val vote_average: Double
)