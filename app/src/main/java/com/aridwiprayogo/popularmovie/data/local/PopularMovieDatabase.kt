package com.aridwiprayogo.popularmovie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aridwiprayogo.popularmovie.data.local.movie.MovieDao
import com.aridwiprayogo.popularmovie.data.local.movie.MovieEntity
import com.aridwiprayogo.popularmovie.data.local.tv.TvDao
import com.aridwiprayogo.popularmovie.data.local.tv.TvEntity

@Database(
    entities = [MovieEntity::class, TvEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PopularMovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvDao
}
