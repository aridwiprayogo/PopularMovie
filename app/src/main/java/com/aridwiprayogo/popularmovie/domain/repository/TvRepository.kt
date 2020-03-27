package com.aridwiprayogo.popularmovie.domain.repository

import com.aridwiprayogo.popularmovie.domain.model.TvMovie

interface TvRepository {
    suspend fun getTvMovie(): List<TvMovie>
    suspend fun saveFavorite(tvMovie: TvMovie)
    suspend fun getFavorite(): List<TvMovie>
}