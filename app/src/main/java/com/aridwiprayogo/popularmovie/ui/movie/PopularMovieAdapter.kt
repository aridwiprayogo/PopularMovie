package com.aridwiprayogo.popularmovie.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aridwiprayogo.popularmovie.domain.model.PopularMovie
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.utils.loadImage
import kotlinx.android.synthetic.main.popular_movie_item.view.*

class PopularMovieAdapter(
    private val listPopularMovie: List<PopularMovie>,
    private val onClick: PopularMovieCallback
): RecyclerView.Adapter<PopularMovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.popular_movie_item, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return listPopularMovie.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listPopularMovie[position],onClick)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        inline fun onBind(
            popularMovie: PopularMovie,
            crossinline onClick: PopularMovieCallback
        ) {
            with(this.view){
                tv_title.text = popularMovie.title
                imageView.loadImage(popularMovie.src)
                this.setOnClickListener {
                    onClick(popularMovie)
                }
            }
        }
    }
}

typealias PopularMovieCallback = (popularMovie: PopularMovie)->Unit
