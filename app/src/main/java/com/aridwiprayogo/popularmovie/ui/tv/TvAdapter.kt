package com.aridwiprayogo.popularmovie.ui.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.domain.model.TvMovie
import com.aridwiprayogo.popularmovie.utils.loadImage
import kotlinx.android.synthetic.main.tv_movie_item.view.*

class TvAdapter(private val listTvMovie: List<TvMovie>, private val onclick:(TvMovie)->Unit)
    : RecyclerView.Adapter<TvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.tv_movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listTvMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listTvMovie[position],onclick)
    }

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun onBind(tvMovie: TvMovie, onclick: (TvMovie) -> Unit){
            with(view){
                tv_tv_title.text = tvMovie.title
                iv_tv_poster.loadImage(tvMovie.image)
                this.setOnClickListener {
                    onclick(tvMovie)
                }
            }
        }
    }
}