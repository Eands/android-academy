package ru.self.appkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MovieDetails : Fragment() {

    private var backListener: MovieDetailsBackClickListener ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    fun setClickListener(listener: MovieDetailsBackClickListener) {
        backListener = listener
    }

    interface MovieDetailsBackClickListener {
        fun onMovieDeselected()
    }
}