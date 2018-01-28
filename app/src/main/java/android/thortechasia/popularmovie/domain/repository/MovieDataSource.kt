package android.thortechasia.popularmovie.domain.repository

import android.thortechasia.popularmovie.domain.model.PopularMovie


interface MovieDataSource {

    suspend fun getPopularMoviesAsync() : List<PopularMovie>

    suspend fun getDetailMovieAsync(id: Int) : PopularMovie

}