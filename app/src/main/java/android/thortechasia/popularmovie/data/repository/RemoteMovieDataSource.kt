package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.remote.PopularMovieModel
import android.thortechasia.popularmovie.network.ApiService
import io.reactivex.Observable

class RemoteMovieDataSource(val apiService: ApiService){

    fun getPopularMovies(): Observable<PopularMovieModel.Response> {
        return apiService.getPopularMovies()
    }
}