package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.PopularMovie
import android.thortechasia.popularmovie.data.local.PopularMovieTable
import io.reactivex.Single

interface MovieDataSource {
    fun getPopularMovie():Single<List<PopularMovie>>
    fun addPopularMovies(movies: List<PopularMovieTable>)
}