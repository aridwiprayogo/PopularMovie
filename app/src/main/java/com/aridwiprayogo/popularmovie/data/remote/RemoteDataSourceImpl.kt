package com.aridwiprayogo.popularmovie.data.remote

import com.aridwiprayogo.popularmovie.data.remote.response.PopularMovieResponse
import com.aridwiprayogo.popularmovie.data.remote.response.TvMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class RemoteDataSourceImpl(val apiService: ApiService) : RemoteDataSource {
    override suspend fun getPopularMovieResponse(): PopularMovieResponse =
        withContext(Dispatchers.IO) {
            async(Dispatchers.IO) { apiService.getPopularMovie() }.await()
        }

    override suspend fun getTvMovieResponse(): TvMovieResponse =
        withContext(Dispatchers.IO) {
            async { apiService.getTvMovie() }.await()
        }
}