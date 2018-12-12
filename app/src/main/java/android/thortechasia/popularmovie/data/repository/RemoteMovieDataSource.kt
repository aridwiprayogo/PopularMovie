package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.lokal.PopularMovieEntity
import android.thortechasia.popularmovie.data.remote.PopularMovieModel
import android.thortechasia.popularmovie.network.ApiService
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteMovieDataSource(val apiService: ApiService){

    fun getPopularMovies(): Single<PopularMovieModel.Response> {
        return apiService.getPopularMovies()
    }
}