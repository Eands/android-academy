package ru.self.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(),
    MoviesListFragment.MoviesListItemClickListener,
    MovieDetailsFragment.MovieDetailsBackClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            routeBack()
        }
    }

    override fun onMovieSelected() {
        Log.i("INFO", "onMovieSelected: inside onMovieSelected method")
        supportFragmentManager.beginTransaction()
            .add(R.id.container, MovieDetailsFragment())
            .commit()

    }

    override fun onMovieDeselected() {
        routeBack()
    }

    private fun routeBack() {
        Log.i("INFO", "routeBack: inside routeBack method")
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MoviesListFragment())
            .commit()
    }
}