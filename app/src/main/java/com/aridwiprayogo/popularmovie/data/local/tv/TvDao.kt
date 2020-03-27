package com.aridwiprayogo.popularmovie.data.local.tv

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TvDao {
    @Insert
    suspend fun saveTv(tvEntity: TvEntity)
    @Query("SELECT * FROM TvEntity")
    suspend fun getTv(): List<TvEntity>
}