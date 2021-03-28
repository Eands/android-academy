package ru.self.appkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MoviesListFragment: Fragment() {

    private var moviesClickListener: MoviesListItemClickListener ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    fun setClickListener(listener: MoviesListItemClickListener) {
        moviesClickListener = listener
    }

    interface MoviesListItemClickListener {
        fun onMovieSelected()
    }
}