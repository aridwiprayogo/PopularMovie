package android.thortechasia.popularmovie.ui.detail

import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.ui.base.BaseViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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
        viewModelScope.launch{
            loading.value = true
            try {
                movie.value = repository.getDetailMovieAsync(id)
            }catch (error: Throwable){
                Timber.e(error)
                this@DetailPresenter.error.value = error
            }finally {
                loading.value = false
            }
        }

    }

}