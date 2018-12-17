package android.thortechasia.popularmovie.network


import android.thortechasia.popularmovie.BuildConfig
import android.thortechasia.popularmovie.data.remote.PopularMovieModel
import android.thortechasia.popularmovie.utils.Constants.Companion.POPULAR_MOVIES
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(POPULAR_MOVIES)
    fun getPopularMovies(@Query("api_key") api_key : String = BuildConfig.API_KEY)
        : Single<PopularMovieModel.Response>

}