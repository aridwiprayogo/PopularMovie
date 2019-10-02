package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.lokal.LocalMovieDataSource
import android.thortechasia.popularmovie.data.lokal.PopularMovieEntity
import android.thortechasia.popularmovie.data.remote.RemoteMovieDataSource
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.domain.repository.MovieDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class MovieRepository(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieDataSource: LocalMovieDataSource
) : MovieDataSource {

    override suspend fun getPopularMoviesAsync() = withContext(Dispatchers.IO) {
        localMovieDataSource.getPopularMovies()
            .let{
                when {
                    it.isEmpty() -> return@withContext getPopularMoviesFromRemote()

                    else -> it.map {
                        PopularMovie.from(it)
                    }
                }
            }
    }

    private suspend fun getPopularMoviesFromRemote(): List<PopularMovie> =
        remoteMovieDataSource.getPopularMoviesAsync().await()
            .movies.map { movies ->
            PopularMovieEntity.from(movies)
        }.let {
            saveToLocal(it)
            it.map { movieEntity ->
                PopularMovie.from(movieEntity)
            }
        }

    private suspend fun saveToLocal(listMovie: List<PopularMovieEntity>) {
        withContext(Dispatchers.IO){
            localMovieDataSource.savePopularMovies(listMovie)
        }
    }

    override suspend fun getDetailMovieAsync(id: Int) = withContext(Dispatchers.IO) {
        val movieDetail = localMovieDataSource.getDetailMovieAsync(id)
        PopularMovie.from(movieDetail)
    }
}