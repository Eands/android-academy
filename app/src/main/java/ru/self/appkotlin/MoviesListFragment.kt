package ru.self.appkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class MoviesListFragment: Fragment() {

    private var moviesClickListener: MoviesListItemClickListener ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ConstraintLayout>(R.id.movies_list_item_layout).apply {
            setOnClickListener {moviesClickListener?.onMovieSelected()}
        }
//        view.findViewById<ConstraintLayout>(R.id.movies_list_item_layout)?.setOnClickListener {
//            moviesClickListener?.onMovieSelected()
//        }
    }

    interface MoviesListItemClickListener {
        fun onMovieSelected()
    }
}