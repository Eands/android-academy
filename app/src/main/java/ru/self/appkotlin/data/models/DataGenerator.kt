package ru.self.appkotlin.data.models

import ru.self.appkotlin.R

object DataGenerator {
    fun generateMovieList() = arrayListOf(
        Movie(
            0,
            12,
            true,
            R.drawable.img_movies_item_header_avengers,
            R.drawable.img_movie_details_header,
            "Action, drama",
            "Tht best film1",
            "120 min",
            "The best of movie description",
            5,
            100,
            arrayListOf(
                Actor(1, "Robert Downey Jr.", R.drawable.img_movie_cast_1),
                Actor(2, "Chris Evans", R.drawable.img_movie_cast_2),
                Actor(3, "Mark Ruffalo", R.drawable.img_movie_cast_3),
                Actor(4, "Chris Hemsworth", R.drawable.img_movie_cast_4),
            )
        ), Movie(
            1,
            12,
            false,
            R.drawable.img_movies_item_header_tenet,
            R.drawable.img_movie_details_header,
            "Action, drama",
            "Tht best film2",
            "120 min",
            "The best of movie description",
            4,
            101,
            arrayListOf(
                Actor(2, "Chris Evans", R.drawable.img_movie_cast_2),
                Actor(1, "Robert Downey Jr.", R.drawable.img_movie_cast_1),
                Actor(3, "Mark Ruffalo", R.drawable.img_movie_cast_3),
                Actor(4, "Chris Hemsworth", R.drawable.img_movie_cast_4),
            )
        ), Movie(
            2,
            12,
            true,
            R.drawable.img_movies_item_header_black_widow,
            R.drawable.img_movie_details_header,
            "Action, drama",
            "Tht best film3",
            "120 min",
            "The best of movie description",
            3,
            102,
            arrayListOf(
                Actor(3, "Mark Ruffalo", R.drawable.img_movie_cast_3),
                Actor(1, "Robert Downey Jr.", R.drawable.img_movie_cast_1),
                Actor(2, "Chris Evans", R.drawable.img_movie_cast_2),
                Actor(4, "Chris Hemsworth", R.drawable.img_movie_cast_4),
            )
        ), Movie(
            3,
            12,
            false,
            R.drawable.img_movies_item_header_ww84,
            R.drawable.img_movie_details_header,
            "Action, drama4",
            "Tht best film4",
            "120 min",
            "The best of movie description",
            2,
            103,
            arrayListOf(
                Actor(4, "Chris Hemsworth", R.drawable.img_movie_cast_4),
                Actor(1, "Robert Downey Jr.", R.drawable.img_movie_cast_1),
                Actor(2, "Chris Evans", R.drawable.img_movie_cast_2),
                Actor(3, "Mark Ruffalo", R.drawable.img_movie_cast_3),
            )
        )
    )
}