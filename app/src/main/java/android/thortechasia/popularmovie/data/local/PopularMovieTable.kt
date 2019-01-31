package android.thortechasia.popularmovie.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.thortechasia.popularmovie.data.remote.PopularMovieModel

@Entity(tableName = "movie")
data class PopularMovieTable(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    @ColumnInfo(name = "poster_path")val poster_path: String,
    val vote_average: Double,
    val overview: String,
    val release_date: String
    ){
    companion object {
        fun from(data: PopularMovieModel.Movies) =
                PopularMovieTable(
                    data.id,
                    data.title,
                    data.poster_path,
                    data.vote_average,
                    data.overview,
                    data.release_date
                )
    }
}