package android.thortechasia.popularmovie.data.lokal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.Deferred

@Dao
interface PopularMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserts(movies: List<PopularMovieEntity>)

    @Query("SELECT * FROM movie")
    suspend fun getPopularMoviesAsync() : List<PopularMovieEntity>

    @Query("SELECT * FROM movie WHERE id = :id")
    suspend fun getDetailMovieAsync(id: Int) : PopularMovieEntity

}