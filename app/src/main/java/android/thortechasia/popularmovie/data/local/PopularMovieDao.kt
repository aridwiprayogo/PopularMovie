package android.thortechasia.popularmovie.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface PopularMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserts(movies: List<PopularMovieTable>)

    @Query("SELECT * FROM movie")
    fun getMovies(): Single<List<PopularMovieTable>>
}