package com.aridwiprayogo.popularmovie.ui.detail_movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aridwiprayogo.popularmovie.domain.model.PopularMovie
import com.aridwiprayogo.popularmovie.domain.repository.MovieRepository
import kotlinx.coroutines.launch

class DetailMovieViewModel(private val repository: MovieRepository): ViewModel() {
    fun saveFavorite(popularMovie: PopularMovie) {
        viewModelScope.launch {
            repository.saveFavorite(popularMovie = popularMovie)
        }
    }

    fun deleteFavorite(popularMovie: PopularMovie){
        viewModelScope.launch {
            val callback = repository.runCatching {
                deleteFavorite(popularMovie)
            }
            callback.getOrThrow()
        }
    }
}