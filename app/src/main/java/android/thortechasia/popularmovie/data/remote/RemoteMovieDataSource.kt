package android.thortechasia.popularmovie.data.remote

import android.thortechasia.popularmovie.network.ApiService
import kotlinx.coroutines.Deferred

class RemoteMovieDataSource(private val apiService: ApiService){

    fun getPopularMoviesAsync(): Deferred<PopularMovieModel.Response> {
        return apiService.getPopularMoviesAsync()
    }
}