package android.thortechasia.popularmovie.ui.movie

import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.utils.scheduler.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MoviePresenter(val movieRepository: MovieRepository,
                     val compositeDisposable: CompositeDisposable,
                     val schedulerProvider: SchedulerProvider) : MovieContract.Presenter {

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
        movieRepository.getPopularMovies()
            .observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribeBy(
            onSuccess = {
                mView?.hideLoading()
                mView?.showPopularMovies(it)
            },
            onError = {
                mView?.hideLoading()
                mView?.failureGetPopularMovies(it)
                Timber.e(it)
            }
        ).addTo(compositeDisposable)
    }
}