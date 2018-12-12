package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.lokal.PopularMovieDao
import android.thortechasia.popularmovie.data.lokal.PopularMovieEntity
import android.thortechasia.popularmovie.data.remote.PopularMovieModel
import io.reactivex.Observable
import io.reactivex.Single

class LokalMovieDataSource(val popularMovieDao: PopularMovieDao) {

    fun getPopularMovies(): Single<List<PopularMovieEntity>> {
        return popularMovieDao.getPopularMovies()
    }

}