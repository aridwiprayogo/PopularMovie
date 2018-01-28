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

    override suspend fun getPopularMoviesAsync(): Deferred<List<PopularMovie>> {
        return withContext(Dispatchers.IO) {
            async {
                remoteMovieDataSource.getPopularMoviesAsync().await()
                    .movies.map {
                    PopularMovie.from(it)
                }
            }
        }
    }

    override suspend fun getDetailMovieAsync(id: Int) =
        withContext(Dispatchers.IO) {
            async {
                val movieDetail = localMovieDataSource.getDetailMovie(id).await()
                return@async PopularMovie.from(movieDetail)
            }
        }
}