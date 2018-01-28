package android.thortechasia.popularmovie.ui.detail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

class DetailPresenter(
    private val repository: MovieRepository
) : BaseViewModel(){

    private val movie = MutableLiveData<PopularMovie>()
    private val loading = MutableLiveData<Boolean>()
    private val error = MutableLiveData<Throwable>()

    fun movie() = this.movie as LiveData<PopularMovie>

    fun getDetailMovie(id: Int) {
        movieJob add launch{
            loading.value = true
            try {
                movie.value = repository.getDetailMovieAsync(id).await()
            }catch (error: Throwable){
                Timber.e(error)
                this@DetailPresenter.error.value = error
            }finally {
                loading.value = false
            }
        }

    }

}