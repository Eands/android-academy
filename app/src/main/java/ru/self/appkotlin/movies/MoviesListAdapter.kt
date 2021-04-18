package ru.self.appkotlin.movies

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.self.appkotlin.R
import ru.self.appkotlin.data.models.Movie

class MoviesListAdapter : ListAdapter<Movie, MoviesListAdapter.MovieViewHolder> {

    private val onClickCard: (item: Movie) -> Unit

    constructor(onClickCard: (item: Movie) -> Unit) : super(DiffCallback()) {
        this.onClickCard = onClickCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item, onClickCard)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pgText = itemView.findViewById<TextView>(R.id.movie_item_pg)
        private val genreText = itemView.findViewById<TextView>(R.id.movie_item_tag)
        private val reviewsText = itemView.findViewById<TextView>(R.id.movie_reviews_count_text)
        private val movieTitleText = itemView.findViewById<TextView>(R.id.movie_item_film_name)
        private val durationText = itemView.findViewById<TextView>(R.id.movie_item_film_duration)
        private val likeImage = itemView.findViewById<ImageView>(R.id.movie_item_like)
        private val starsImages: List<ImageView> = listOf(
            itemView.findViewById(R.id.movie_rating_star1_image),
            itemView.findViewById(R.id.movie_rating_star2_image),
            itemView.findViewById(R.id.movie_rating_star3_image),
            itemView.findViewById(R.id.movie_rating_star4_image),
            itemView.findViewById(R.id.movie_rating_star5_image)
        )
        private val movieImage = itemView.findViewById<ImageView>(R.id.movie_item_header_image)

        fun onBind(movie: Movie, onClickCard: (item: Movie) -> Unit) {
            pgText.text = movie.pgAge.toString()
            genreText.text = movie.genres
            reviewsText.text = movie.reviews.toString()
            movieTitleText.text = movie.title
            durationText.text = movie.duration

            movieImage.setImageResource(movie.imageRes)

            val likeColor = if (movie.isLiked) {
                R.color.light_pink
            } else {
                R.color.white
            }

            ImageViewCompat.setImageTintList(
                likeImage, ColorStateList.valueOf(
                    ContextCompat.getColor(likeImage.context, likeColor)
                )
            )

            starsImages.forEachIndexed { index, imageView ->
                val starColor = if (movie.stars > index) R.color.light_pink else R.color.dark_gray
                ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(
                    ContextCompat.getColor(imageView.context, starColor)
                ))
            }

            itemView.setOnClickListener {
                onClickCard(movie)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem == newItem
    }
}