package android.thortechasia.popularmovie.domain.model

import android.os.Parcelable
import android.thortechasia.popularmovie.data.lokal.PopularMovieEntity
import android.thortechasia.popularmovie.data.remote.PopularMovieModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularMovie(val id: Int,
                        val title: String,
                        val image: String,
                        val desc: String): Parcelable {
    companion object {
        fun from(data: PopularMovieEntity) =
            PopularMovie(data.id,
                         data.title,
                         data.image,
                         data.description)

        fun from(data: PopularMovieModel.Movies) =
            PopularMovie(data.id,
                         data.title,
                         data.poster_path,
                         data.overview)
    }
}