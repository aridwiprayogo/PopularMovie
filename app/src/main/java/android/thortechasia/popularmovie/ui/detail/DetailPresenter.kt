package android.thortechasia.popularmovie.ui.detail

import android.thortechasia.popularmovie.data.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class DetailPresenter(val repository: MovieRepository,
                      val compositeDisposable: CompositeDisposable
) : DetailContract.Presenter {

    private var mView : DetailContract.View? = null

    override fun onAttach(view: DetailContract.View) {
        mView = view
    }

    override fun onDetach() {
        mView = null
        compositeDisposable.clear()
    }

    override fun getDetailMovie(id: Int) {
        repository.getDetailMovie(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                mView?.showDetail(it)
            },{
                Timber.e(it)
            }).addTo(compositeDisposable)
    }

}