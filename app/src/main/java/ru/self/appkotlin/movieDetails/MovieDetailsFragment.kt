package ru.self.appkotlin.movieDetails

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.self.appkotlin.R
import ru.self.appkotlin.data.models.Movie

class MovieDetailsFragment : Fragment() {

    private var backListener: MovieDetailsBackClickListener?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MovieDetailsBackClickListener) {
            backListener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieData = arguments?.getSerializable(PARAM_MOVIE_DATA) as? Movie ?: return
        updateMovieDetailsInfo(movieData)

        view.findViewById<RecyclerView>(R.id.recycle_actors).apply {
            this.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val adapter = ActorsListAdapter()
            this.adapter = adapter
            adapter.submitList(movieData.actors)
        }

        view.findViewById<View>(R.id.back_button_text).apply {
            setOnClickListener { backListener?.onMovieDeselected() }
        }
    }

    private fun updateMovieDetailsInfo(movie: Movie) {
        view?.findViewById<ImageView>(R.id.movie_logo_image)?.setImageResource(movie.detailImageRes)
        view?.findViewById<TextView>(R.id.movie_age_restrictions_text)?.text = movie.pgAge.toString()
        view?.findViewById<TextView>(R.id.movie_name_text)?.text = movie.title
        view?.findViewById<TextView>(R.id.movie_tags_text)?.text = movie.genres
        val starsImages = listOf<ImageView?>(
            view?.findViewById(R.id.movie_rating_star1_image),
            view?.findViewById(R.id.movie_rating_star2_image),
            view?.findViewById(R.id.movie_rating_star3_image),
            view?.findViewById(R.id.movie_rating_star4_image),
            view?.findViewById(R.id.movie_rating_star5_image)
        )
        view?.findViewById<TextView>(R.id.movie_storyline_text)?.text = movie.description

        starsImages.forEachIndexed { index, imageView ->
            imageView?.let {
                val starColor = if (movie.stars > index) R.color.light_pink else R.color.dark_gray
                ImageViewCompat.setImageTintList(it, ColorStateList.valueOf(
                    ContextCompat.getColor(it.context, starColor)
                ))
            }
        }
    }

    interface MovieDetailsBackClickListener {
        fun onMovieDeselected()
    }

    companion object {
        private const val PARAM_MOVIE_DATA = "movie_data"

        fun create(movieData: Movie) = MovieDetailsFragment().also {
            val args = bundleOf(
                PARAM_MOVIE_DATA to movieData
            )
            it.arguments = args
        }
    }
}