package android.thortechasia.popularmovie.domain.repository

import android.thortechasia.popularmovie.domain.model.PopularMovie
import kotlinx.coroutines.Deferred


interface MovieDataSource {

    suspend fun getPopularMoviesAsync() : Deferred<List<PopularMovie>>

    suspend fun getDetailMovieAsync(id: Int) : Deferred<PopularMovie>

}