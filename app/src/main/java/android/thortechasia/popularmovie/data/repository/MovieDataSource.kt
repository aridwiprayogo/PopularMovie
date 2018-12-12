package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.PopularMovie
import android.thortechasia.popularmovie.data.lokal.PopularMovieEntity
import io.reactivex.Single


interface MovieDataSource {

    fun getPopularMovies() : Single<List<PopularMovie>>

    fun addPopularMovies(movies: List<PopularMovieEntity>)

}