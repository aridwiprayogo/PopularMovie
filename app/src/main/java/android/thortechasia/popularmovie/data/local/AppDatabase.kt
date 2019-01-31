package android.thortechasia.popularmovie.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(PopularMovieTable::class),version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun popularMovieDao(): PopularMovieDao
}