package android.thortechasia.popularmovie.ui.movie

import android.thortechasia.popularmovie.data.repository.MovieRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

class MoviePresenter(val movieRepository: MovieRepository,
                     val compositeDisposable: CompositeDisposable) : MovieContract.Presenter {

    private var mView: MovieContract.View? = null

    override fun onAttach(view: MovieContract.View) {
        mView = view
    }

    override fun onDetach() {
        mView = null
        compositeDisposable.clear()
    }

    override fun getPopularMovies() {
        mView?.showLoading()
        movieRepository.getPopularMovies().subscribeBy(
            onNext = {
                mView?.hideLoading()
                mView?.showPopularMovies(it.movies)
                Timber.d("success get movie")
            },
            onError = {
                mView?.hideLoading()
                Timber.e(it)
            }
        ).addTo(compositeDisposable)
    }
}