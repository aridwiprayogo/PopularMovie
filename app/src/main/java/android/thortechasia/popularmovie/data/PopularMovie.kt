package android.thortechasia.popularmovie.data

import android.thortechasia.popularmovie.data.local.PopularMovieTable
import android.thortechasia.popularmovie.data.remote.PopularMovieModel

data class PopularMovie(
    val id: Int,
    val title: String,
    val image: String,
    val desc: String
){
    companion object {
        fun from(data: PopularMovieTable) =
                PopularMovie(
                    data.id,
                    data.title,
                    data.poster_path,
                    data.overview
                )

        fun from(data: PopularMovieModel.Movies) = PopularMovie(
            data.id,
            data.title,
            data.poster_path,
            data.overview
        )
    }
}