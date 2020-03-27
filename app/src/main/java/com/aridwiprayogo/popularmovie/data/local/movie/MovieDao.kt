package com.aridwiprayogo.popularmovie.data.local.movie

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert
    suspend fun saveMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM MovieEntity")
    suspend fun getMovie(): List<MovieEntity>

    @Delete
    fun deleteFavorite(vararg movieEntity: MovieEntity)
}