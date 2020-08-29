package com.aridwiprayogo.popularmovie.data

import com.aridwiprayogo.popularmovie.data.local.tv.LocalTvDataSource
import com.aridwiprayogo.popularmovie.data.local.tv.TvEntity
import com.aridwiprayogo.popularmovie.data.remote.RemoteDataSource
import com.aridwiprayogo.popularmovie.domain.model.TvMovie
import com.aridwiprayogo.popularmovie.domain.repository.TvRepository
import javax.inject.Inject

class TvRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalTvDataSource
): TvRepository {
    override suspend fun getTvMovie(): List<TvMovie> {
        return remoteDataSource.getTvMovieResponse().results
            .map{ result ->
                TvMovie(
                    id = result.id,
                    overview = result.overview,
                    release_date = result.firstAirDate,
                    title = result.name,
                    image = result.posterPath,
                    vote_count = result.voteCount,
                    vote_average = result.voteAverage
                    )
            }
    }

    override suspend fun saveFavorite(tvMovie: TvMovie) {
        localDataSource.saveFavorite(TvEntity(
            id = tvMovie.id,
            title = tvMovie.title,
            release_date = tvMovie.release_date,
            vote_count = tvMovie.vote_count,
            vote_average = tvMovie.vote_average,
            overview = tvMovie.overview,
            image = tvMovie.image
        ))
    }

    override suspend fun getFavorite(): List<TvMovie> {
        return localDataSource.getFavorite()
            .map { tvEntity ->
                TvMovie(
                    id = tvEntity.id,
                    overview = tvEntity.overview,
                    release_date = tvEntity.release_date,
                    title = tvEntity.title,
                    image = tvEntity.image,
                    vote_count = tvEntity.vote_count,
                    vote_average = tvEntity.vote_average
                )
            }
    }
}