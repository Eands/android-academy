package ru.self.appkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MovieDetailsFragment : Fragment() {

    private var backListener: MovieDetailsBackClickListener ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.back_button_text).apply {
            setOnClickListener { backListener?.onMovieDeselected() }
        }
//        view.findViewById<TextView>(R.id.back_button_text)?.setOnClickListener {
//            backListener?.onMovieDeselected()
//        }
    }

    interface MovieDetailsBackClickListener {
        fun onMovieDeselected()
    }
}