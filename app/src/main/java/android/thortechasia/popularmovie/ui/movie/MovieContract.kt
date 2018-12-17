package android.thortechasia.popularmovie.ui.movie

import android.thortechasia.popularmovie.data.PopularMovie
import android.thortechasia.popularmovie.data.remote.PopularMovieModel
import android.thortechasia.popularmovie.ui.base.BaseContract

interface MovieContract {

    interface Presenter : BaseContract.Presenter<View> {
        fun getPopularMovies()
    }

    interface View : BaseContract.View {
        fun showLoading()
        fun hideLoading()
        fun showPopularMovies(movies: List<PopularMovie>)
    }

}