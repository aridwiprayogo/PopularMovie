package android.thortechasia.popularmovie.ui.movie

import android.support.v7.widget.RecyclerView
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.utils.Constants
import android.thortechasia.popularmovie.utils.loadImage
import android.thortechasia.popularmovie.data.PopularMovie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row_popular_movies.view.*

class MovieAdapter(var movies: List<PopularMovie>,
                   var listener: (PopularMovie) -> Unit)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_row_popular_movies, p0, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(p0: MovieViewHolder, p1: Int) {
        p0.bindItems(movies[p1], listener)
    }
}

class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){

    fun bindItems(movie: PopularMovie,
                  listener: (PopularMovie) -> Unit) = with(itemView){
        imgPoster.loadImage(context,
            "${Constants.BASE_IMAGE_URL}${movie.image}")

        setOnClickListener { listener(movie) }
    }

}