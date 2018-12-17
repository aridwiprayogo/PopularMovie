package android.thortechasia.popularmovie.ui.detail

import android.thortechasia.popularmovie.data.PopularMovie
import android.thortechasia.popularmovie.ui.base.BaseContract

interface DetailContract {

    interface Presenter : BaseContract.Presenter<View> {
        fun getDetailMovie(id: Int)
    }

    interface View : BaseContract.View {
        fun showDetail(movie: PopularMovie)
    }

}