package com.aridwiprayogo.popularmovie.data.remote

import com.aridwiprayogo.popularmovie.BuildConfig
import com.aridwiprayogo.popularmovie.data.remote.response.PopularMovieResponse
import com.aridwiprayogo.popularmovie.data.remote.response.TvMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/3/movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String=BuildConfig.API_KEY,
        @Query("language") language: String="en-US"):PopularMovieResponse
    @GET("/3/discover/tv")
    suspend fun getTvMovie(
        @Query("api_key") apiKey: String=BuildConfig.API_KEY,
        @Query("language") language: String="en-US"): TvMovieResponse
}