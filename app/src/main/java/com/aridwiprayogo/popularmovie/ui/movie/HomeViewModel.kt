package com.aridwiprayogo.popularmovie.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aridwiprayogo.popularmovie.domain.model.PopularMovie
import com.aridwiprayogo.popularmovie.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    private val listMovieLiveData = MutableLiveData<List<PopularMovie>>()
    private val loadingLiveData = MutableLiveData<Boolean>()
    private val errorLiveData = MutableLiveData<Exception>()

    internal fun getPopularMovieData()=
        listMovieLiveData as LiveData<List<PopularMovie>>

    internal fun getLoading()=
        loadingLiveData as LiveData<Boolean>

    internal fun getError()=
        errorLiveData as LiveData<Exception>

    fun getPopularMovie(){
        viewModelScope.launch(Dispatchers.Main) {
            loadingLiveData.value=true
            try {
                val movie = repository.getPopularMovie()
                Timber.d(movie.toString())
                loadingLiveData.value=false
                listMovieLiveData.postValue(movie)
            }catch (err: Exception){
                Timber.e(err.localizedMessage)
                loadingLiveData.value=false
                errorLiveData.postValue(err)
            }
        }
    }

}