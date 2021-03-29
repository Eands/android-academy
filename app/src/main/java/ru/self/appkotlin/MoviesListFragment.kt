package ru.self.appkotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MoviesListFragment: Fragment() {

    private var moviesClickListener: MoviesListItemClickListener ?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MoviesListItemClickListener) {
            moviesClickListener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.movies_list_item_layout).apply {
            setOnClickListener {moviesClickListener?.onMovieSelected()}
        }
    }

    interface MoviesListItemClickListener {
        fun onMovieSelected()
    }
}