package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.lokal.LokalMovieDataSource
import android.thortechasia.popularmovie.data.remote.RemoteMovieDataSource
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.domain.repository.MovieDataSource
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MovieRepository(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieDataSource: LokalMovieDataSource
) : MovieDataSource {

    override suspend fun getPopularMoviesAsync(): List<PopularMovie> {
        return withContext(Dispatchers.IO) {
            remoteMovieDataSource.getPopularMoviesAsync().await()
                .movies.map {
                PopularMovie.from(it)
            }
        }
    }

    override suspend fun getDetailMovieAsync(id: Int): PopularMovie {
        return withContext(Dispatchers.IO) {
            val movieDetail = localMovieDataSource.getDetailMovieAsync(id).await()
            PopularMovie.from(movieDetail)
        }
    }
}