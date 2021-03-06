package com.aridwiprayogo.popularmovie.ui.detail_tv

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aridwiprayogo.popularmovie.domain.model.TvMovie
import com.aridwiprayogo.popularmovie.domain.repository.TvRepository
import kotlinx.coroutines.launch

class DetailTvViewModel @ViewModelInject constructor(private val repository: TvRepository): ViewModel() {
    fun saveFavorite(tvMovie: TvMovie){
        viewModelScope.launch {
            repository.saveFavorite(tvMovie = tvMovie)
        }
    }
}