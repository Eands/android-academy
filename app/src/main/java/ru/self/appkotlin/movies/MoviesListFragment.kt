package ru.self.appkotlin.movies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.self.appkotlin.R
import ru.self.appkotlin.data.models.DataGenerator
import ru.self.appkotlin.data.models.Movie

class MoviesListFragment: Fragment() {

    private var moviesClickListener: MoviesListItemClickListener?= null

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

        view.findViewById<RecyclerView>(R.id.recycler_movies).apply {
            this.layoutManager = GridLayoutManager(this.context, 2)
            val adapter = MoviesListAdapter {
                moviesClickListener?.onMovieSelected(it)
            }
            setAdapter(adapter)
            adapter.submitList(DataGenerator.generateMovieList())
        }
    }

    interface MoviesListItemClickListener {
        fun onMovieSelected(movie: Movie)
    }
}