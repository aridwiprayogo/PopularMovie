package com.aridwiprayogo.popularmovie.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aridwiprayogo.popularmovie.domain.model.PopularMovie
import com.aridwiprayogo.popularmovie.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(private val repository: MovieRepository,
                                                 private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {
    // TODO: Implement the ViewModel
    private val listMovieLiveData = MutableLiveData<List<PopularMovie>>()
    private val loadingLiveData = MutableLiveData<Boolean>()
    private val errorLiveData = MutableLiveData<Exception>()

    internal val popularMovieData get() = listMovieLiveData as LiveData<List<PopularMovie>>

    internal val loading get() = loadingLiveData as LiveData<Boolean>

    internal val error get() = errorLiveData as LiveData<Exception>

    fun getPopularMovie(){
        viewModelScope.launch(coroutineDispatcher) {
            loadingLiveData.postValue(true)
            try {
                val movie = repository.getPopularMovie()
                Timber.d(movie.toString())
                loadingLiveData.postValue(false)
                listMovieLiveData.postValue(movie)
            }catch (err: Exception){
                Timber.e(err.localizedMessage)
                loadingLiveData.postValue(false)
                errorLiveData.postValue(err)
            }
        }
    }

}