package android.thortechasia.popularmovie.data

import com.google.gson.annotations.SerializedName

object PopularMovieModel {

    data class Response(
        val page: Int,
        val total_results: Int,
        val total_pages: Int,
        @SerializedName("results")
        val movies: List<Movies>
    )

    data class Movies(
        val vote_count: Int,
        val id: Int,
        val video: Boolean,
        val vote_average: Double,
        val title: String,
        val popularity: Double,
        val poster_path: String,
        val original_language: String,
        val original_title: String,
        val genre_ids: List<Int>,
        val backdrop_path: String,
        val adult: Boolean,
        val overview: String,
        val release_date: String
    )

}