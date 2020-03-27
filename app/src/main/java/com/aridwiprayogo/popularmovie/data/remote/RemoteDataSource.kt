package com.aridwiprayogo.popularmovie.data.remote

import com.aridwiprayogo.popularmovie.data.remote.response.PopularMovieResponse
import com.aridwiprayogo.popularmovie.data.remote.response.TvMovieResponse

interface RemoteDataSource {
    suspend fun getPopularMovieResponse(): PopularMovieResponse
    suspend fun getTvMovieResponse(): TvMovieResponse
}
