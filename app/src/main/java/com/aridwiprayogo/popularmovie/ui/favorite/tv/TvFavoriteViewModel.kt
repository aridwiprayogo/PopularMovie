package com.aridwiprayogo.popularmovie.ui.favorite.tv

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aridwiprayogo.popularmovie.domain.model.TvMovie
import com.aridwiprayogo.popularmovie.domain.repository.TvRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class TvFavoriteViewModel @ViewModelInject constructor(private val repository: TvRepository) : ViewModel() {
    private val tvFavoriteLiveData = MutableLiveData<List<TvMovie>>()
    fun getTvFavorite() = tvFavoriteLiveData as LiveData<List<TvMovie>>
    init{
        viewModelScope.launch{
            try {
                val data = repository.getFavorite()
                tvFavoriteLiveData.postValue(data)
            } catch (e: Exception) {
                e.printStackTrace()
                Timber.d(e)
            }
        }
    }
}
