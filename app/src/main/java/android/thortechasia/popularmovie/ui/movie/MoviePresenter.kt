package android.thortechasia.popularmovie.ui.movie

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MoviePresenter(
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private val movies = MutableLiveData<List<PopularMovie>>()
    private val loading = MutableLiveData<Boolean>()
    private val error = MutableLiveData<Throwable>()

    fun movie() = this.movies as LiveData<List<PopularMovie>>
    fun loading() = this.loading as LiveData<Boolean>
    fun error() = this.error as LiveData<Throwable>


    fun getPopularMovies() {

        movieJob add launch{
            loading.value = true
            try {
                loading.value = false
                movies.value = movieRepository.getPopularMoviesAsync().await()
            }catch (err: Throwable){
                loading.value = false
                error.value = err
            }finally {
                loading.value = false
            }
        }

    }
}