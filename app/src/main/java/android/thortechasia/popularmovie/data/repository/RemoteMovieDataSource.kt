package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.remote.PopularMovieModel
import android.thortechasia.popularmovie.network.ApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteMovieDataSource(val apiService: ApiService){
    fun getPopularMovie(): Single<PopularMovieModel.Response> {
        return apiService.getPopularMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}