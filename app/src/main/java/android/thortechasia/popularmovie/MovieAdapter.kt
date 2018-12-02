package android.thortechasia.popularmovie

import android.support.v7.widget.RecyclerView
import android.thortechasia.popularmovie.Utils.Constants
import android.thortechasia.popularmovie.Utils.loadImage
import android.thortechasia.popularmovie.data.PopularMovieModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row_popular_movies.view.*

class MovieAdapter(var movies: List<PopularMovieModel.Movies>)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_row_popular_movies, p0, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(p0: MovieViewHolder, p1: Int) {
        p0.bindItems(movies[p1])
    }
}

class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){

    fun bindItems(movie: PopularMovieModel.Movies) = with(itemView){
        imgPoster.loadImage(context,
            "${Constants.BASE_IMAGE_URL}${movie.poster_path}")
    }

}