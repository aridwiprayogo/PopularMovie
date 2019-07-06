package android.thortechasia.popularmovie.data.remote

import android.thortechasia.popularmovie.network.ApiService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class RemoteMovieDataSource(private val apiService: ApiService){

    suspend fun getPopularMoviesAsync(): Deferred<PopularMovieModel.Response> {
        return withContext(Dispatchers.IO){async { apiService.getPopularMoviesAsync() }}
    }
}