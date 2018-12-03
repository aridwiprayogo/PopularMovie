package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.PopularMovieModel
import android.thortechasia.popularmovie.network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteMovieDataSource(val apiService: ApiService) : MovieDataSource {

    override fun getPopularMovies(): Observable<PopularMovieModel.Response> {
        return apiService.getPopularMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}