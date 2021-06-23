package com.android.academy.fundamentals.homework.service

import com.android.academy.fundamentals.homework.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/movie/popular")
    suspend fun getPopular(@Query("page") page: Int) : Call<MutableList<Movie>>
}
