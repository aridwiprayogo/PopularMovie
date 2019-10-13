package android.thortechasia.popularmovie.ui.movie

import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.utils.Constants
import android.thortechasia.popularmovie.utils.loadImage
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_list_row_item.view.*

class MovieAdapter(var movies: List<PopularMovie>,
                   private var listener: (PopularMovie) -> Unit)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MovieViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_list_row_item, viewGroup, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        viewHolder.bindItems(movies[position], listener)
    }
}

class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){

    fun bindItems(movie: PopularMovie, listener: (PopularMovie) -> Unit) =
        with(itemView){

        imgPoster.loadImage("${Constants.BASE_IMAGE_URL}${movie.image}")

        setOnClickListener { listener(movie) }
    }

}