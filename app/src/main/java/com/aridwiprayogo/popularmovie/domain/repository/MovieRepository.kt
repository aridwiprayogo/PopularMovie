package com.aridwiprayogo.popularmovie.domain.repository

import com.aridwiprayogo.popularmovie.domain.model.PopularMovie

interface MovieRepository {
    suspend fun getPopularMovie(): List<PopularMovie>
    suspend fun saveFavorite(popularMovie: PopularMovie)
    suspend fun getFavoriteMovie(): List<PopularMovie>
    suspend fun deleteFavorite(popularMovie: PopularMovie)
}
