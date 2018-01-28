package android.thortechasia.popularmovie.data.lokal

import android.thortechasia.popularmovie.data.remote.PopularMovieModel
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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