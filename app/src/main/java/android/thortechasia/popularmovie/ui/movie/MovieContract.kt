package android.thortechasia.popularmovie.ui.movie

import android.thortechasia.popularmovie.data.PopularMovieModel
import android.thortechasia.popularmovie.ui.base.BaseContract

interface MovieContract {

    interface Presenter : BaseContract.Presenter<View> {
        fun getPopularMovies()
    }

    interface View : BaseContract.View {
        fun showPopularMovies(movies: List<PopularMovieModel.Movies>)
    }

}