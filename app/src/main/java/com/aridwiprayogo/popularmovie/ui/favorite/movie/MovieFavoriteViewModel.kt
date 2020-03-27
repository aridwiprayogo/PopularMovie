package com.aridwiprayogo.popularmovie.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aridwiprayogo.popularmovie.domain.model.PopularMovie
import com.aridwiprayogo.popularmovie.domain.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieFavoriteViewModel(private val repository: MovieRepository) : ViewModel() {
    private val movieFavoriteLiveData = MutableLiveData<List<PopularMovie>>()
    fun getMovieFavorite() = movieFavoriteLiveData as LiveData<List<PopularMovie>>

    init {
        viewModelScope.launch {
            val movieFavorite = repository.getFavoriteMovie()
            this@MovieFavoriteViewModel.movieFavoriteLiveData.postValue(movieFavorite)
        }
    }
}
