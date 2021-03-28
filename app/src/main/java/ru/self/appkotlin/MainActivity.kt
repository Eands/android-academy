package ru.self.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),
    MoviesListFragment.MoviesListItemClickListener,
    MovieDetailsFragment.MovieDetailsBackClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movies_list)
    }

    override fun onMovieSelected() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, MovieDetailsFragment())
            .commit()
    }

    override fun onMovieDeselected() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MoviesListFragment())
            .commit()
    }
}