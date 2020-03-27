package com.aridwiprayogo.popularmovie.data

import com.aridwiprayogo.popularmovie.data.local.movie.LocalMovieDataSource
import com.aridwiprayogo.popularmovie.data.local.movie.MovieEntity
import com.aridwiprayogo.popularmovie.data.remote.RemoteDataSource
import com.aridwiprayogo.popularmovie.domain.model.PopularMovie
import com.aridwiprayogo.popularmovie.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalMovieDataSource
) : MovieRepository {
    override suspend fun getPopularMovie() =
        withContext(Dispatchers.IO) {
            remoteDataSource.getPopularMovieResponse()
                .results
                .map { result ->
                    PopularMovie(
                        id = result.id,
                        title = result.title,
                        src = result.posterPath,
                        overview = result.overview,
                        releaseDate = result.releaseDate,
                        backdropPath = result.backdropPath,
                        voteCount = result.voteCount,
                        voteAverage = result.voteAverage
                    )
                }
        }

    override suspend fun saveFavorite(popularMovie: PopularMovie) {
        withContext(Dispatchers.IO) {
            localDataSource.saveFavorite(
                entity = MovieEntity(
                    id = popularMovie.id,
                    title = popularMovie.title,
                    src = popularMovie.src,
                    overview = popularMovie.overview,
                    releaseDate = popularMovie.releaseDate,
                    backdropPath = popularMovie.backdropPath,
                    voteCount = popularMovie.voteCount,
                    voteAverage = popularMovie.voteAverage
                )
            )
        }
    }

    override suspend fun getFavoriteMovie(): List<PopularMovie> =
        localDataSource.getFavorite()
            .map { movieEntity ->
                PopularMovie(
                    id = movieEntity.id,
                    title = movieEntity.title,
                    src = movieEntity.src,
                    overview = movieEntity.overview,
                    releaseDate = movieEntity.releaseDate,
                    backdropPath = movieEntity.backdropPath,
                    voteCount = movieEntity.voteCount,
                    voteAverage = movieEntity.voteAverage
                )
            }

    override suspend fun deleteFavorite(popularMovie: PopularMovie) {
        localDataSource.deleteFavorite(entity = *arrayOf(MovieEntity(
            id = popularMovie.id,
            title = popularMovie.title,
            src = popularMovie.src,
            overview = popularMovie.overview,
            releaseDate = popularMovie.releaseDate,
            backdropPath = popularMovie.backdropPath,
            voteCount = popularMovie.voteCount,
            voteAverage = popularMovie.voteAverage
        )))
    }
}
