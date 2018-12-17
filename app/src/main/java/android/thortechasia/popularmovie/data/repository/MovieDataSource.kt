package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.PopularMovie
import io.reactivex.Single


interface MovieDataSource {

    fun getPopularMovies() : Single<List<PopularMovie>>

    fun getDetailMovie(id: Int) : Single<PopularMovie>

}