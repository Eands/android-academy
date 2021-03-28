package ru.self.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),
    MoviesListFragment.MoviesListItemClickListener,
    MovieDetails.MovieDetailsBackClickListener {

    private val backListener = MoviesListFragment().apply { setClickListener(this@MainActivity) }
    private val detailsListener = MovieDetails().apply { setClickListener(this@MainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movies_list)
    }

    override fun onMovieSelected() {
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.container, detailsListener)
                commit()
            }
    }

    override fun onMovieDeselected() {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.container, backListener)
                commit()
            }
    }
}