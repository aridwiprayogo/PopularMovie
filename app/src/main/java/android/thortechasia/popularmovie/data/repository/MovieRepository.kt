package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.lokal.LokalMovieDataSource
import android.thortechasia.popularmovie.data.remote.RemoteMovieDataSource
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.domain.repository.MovieDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class MovieRepository(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieDataSource: LokalMovieDataSource
) : MovieDataSource {

    override suspend fun getPopularMoviesAsync() = withContext(Dispatchers.IO) {
        localMovieDataSource.getPopularMovies()
            .map {
                when {
                    it.equals(null) -> return@withContext getPopularMoviesFromRemote()
                    else -> PopularMovie.from(it)
                }
            }
    }

    private suspend fun getPopularMoviesFromRemote(): List<PopularMovie> =
        remoteMovieDataSource.getPopularMoviesAsync().await()
            .movies.map {
            PopularMovie.from(it)
        }

    override suspend fun getDetailMovieAsync(id: Int) = withContext(Dispatchers.IO) {
        val movieDetail = localMovieDataSource.getDetailMovieAsync(id)
        PopularMovie.from(movieDetail)
    }
}