package com.aridwiprayogo.popularmovie.di

import com.aridwiprayogo.popularmovie.ui.detail_movie.DetailMovieViewModel
import com.aridwiprayogo.popularmovie.ui.detail_tv.DetailTvViewModel
import com.aridwiprayogo.popularmovie.ui.favorite.movie.MovieFavoriteViewModel
import com.aridwiprayogo.popularmovie.ui.favorite.tv.TvFavoriteViewModel
import com.aridwiprayogo.popularmovie.ui.movie.HomeViewModel
import com.aridwiprayogo.popularmovie.ui.tv.TvViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { TvViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
    viewModel { DetailTvViewModel(get()) }
    viewModel { MovieFavoriteViewModel(get()) }
    viewModel { TvFavoriteViewModel(get()) }
}
