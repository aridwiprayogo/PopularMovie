package android.thortechasia.popularmovie.data.lokal

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PopularMovieEntity::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun popularMovieDao() : PopularMovieDao

}