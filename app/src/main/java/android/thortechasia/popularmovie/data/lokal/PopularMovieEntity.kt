package android.thortechasia.popularmovie.data.lokal

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.thortechasia.popularmovie.data.remote.PopularMovieModel

@Entity(tableName = "movie")
data class PopularMovieEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val title: String,
    @ColumnInfo(name = "poster_path") val image: String,
    val vote_average: Double,
    @ColumnInfo(name = "overview") val description: String,
    val release_date: String
){
    companion object {
        fun from(data: PopularMovieModel.Movies) = PopularMovieEntity(
            data.id,
            data.title,
            data.poster_path,
            data.vote_average,
            data.overview,
            data.release_date
        )
    }
}