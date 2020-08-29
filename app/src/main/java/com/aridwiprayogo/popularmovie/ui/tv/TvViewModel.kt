package com.aridwiprayogo.popularmovie.ui.tv

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aridwiprayogo.popularmovie.domain.model.TvMovie
import com.aridwiprayogo.popularmovie.domain.repository.TvRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class TvViewModel @ViewModelInject constructor(private val repository: TvRepository) : ViewModel() {
    private val listTvMovieLiveData = MutableLiveData<List<TvMovie>>()
    private val loadingLiveData = MutableLiveData<Boolean>()
    private val errorLiveData = MutableLiveData<Exception>()

    internal fun listTvMovieData()=
        listTvMovieLiveData as LiveData<List<TvMovie>>
    internal fun getLoading()=
        loadingLiveData as LiveData<Boolean>
    internal fun getError()=
        errorLiveData as LiveData<Exception>

    fun getTvMovie(){
        viewModelScope.launch {
            loadingLiveData.postValue(true)
            try {
                loadingLiveData.postValue(false)
                val listTvMovie = repository.getTvMovie()
                Timber.d(listTvMovie.toString())
                listTvMovieLiveData.postValue(listTvMovie)
            }catch (err: Exception){
                Timber.e(err)
                loadingLiveData.postValue(false)
                errorLiveData.postValue(err)
            }

        }
    }
}
