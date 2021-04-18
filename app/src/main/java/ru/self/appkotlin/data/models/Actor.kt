package ru.self.appkotlin.data.models

import androidx.annotation.DrawableRes

data class Actor(
    val id: Int,
    val name: String,
    @DrawableRes val imageRes: Int
)