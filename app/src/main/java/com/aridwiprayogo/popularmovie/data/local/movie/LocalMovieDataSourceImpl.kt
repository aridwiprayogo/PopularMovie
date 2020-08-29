package com.aridwiprayogo.popularmovie.data.local.movie
import com.aridwiprayogo.popularmovie.data.local.LocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalMovieDataSourceImpl @Inject constructor(private val movieDao: MovieDao): LocalMovieDataSource {
    override suspend fun saveFavorite(entity: MovieEntity) {
        withContext(Dispatchers.IO){ movieDao.saveMovie(entity) }
    }

    override suspend fun getFavorite(): List<MovieEntity> {
        return withContext(Dispatchers.IO){
            async { movieDao.getMovie() }.await()
        }
    }

    override suspend fun deleteFavorite(vararg entity: MovieEntity) {
        withContext(Dispatchers.IO){ movieDao.deleteFavorite(movieEntity = *entity) }
    }
}

interface LocalMovieDataSource: LocalDataSource<MovieEntity>

