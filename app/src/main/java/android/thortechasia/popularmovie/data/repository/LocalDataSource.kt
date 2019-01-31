package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.local.PopularMovieDao
import android.thortechasia.popularmovie.data.local.PopularMovieTable
import io.reactivex.Single

class LocalDataSource(val popularMovieDao: PopularMovieDao){


    fun getPopularMovie(): Single<List<PopularMovieTable>> {
        return popularMovieDao.getMovies()
    }
}