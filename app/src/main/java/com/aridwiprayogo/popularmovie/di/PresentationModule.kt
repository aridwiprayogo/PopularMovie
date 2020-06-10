package com.aridwiprayogo.popularmovie.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aridwiprayogo.popularmovie.ViewModelProviderFactory
import com.aridwiprayogo.popularmovie.ui.detail_movie.DetailMovieViewModel
import com.aridwiprayogo.popularmovie.ui.detail_tv.DetailTvViewModel
import com.aridwiprayogo.popularmovie.ui.favorite.movie.MovieFavoriteViewModel
import com.aridwiprayogo.popularmovie.ui.favorite.tv.TvFavoriteViewModel
import com.aridwiprayogo.popularmovie.ui.movie.HomeViewModel
import com.aridwiprayogo.popularmovie.ui.tv.TvViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//import com.aridwiprayogo.popularmovie.ui.detail_movie.DetailMovieViewModel
//import com.aridwiprayogo.popularmovie.ui.detail_tv.DetailTvViewModel
//import com.aridwiprayogo.popularmovie.ui.favorite.movie.MovieFavoriteViewModel
//import com.aridwiprayogo.popularmovie.ui.favorite.tv.TvFavoriteViewModel
//import com.aridwiprayogo.popularmovie.ui.movie.HomeViewModel
//import com.aridwiprayogo.popularmovie.ui.tv.TvViewModel
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.dsl.module

//val presentationModule = module {
//    viewModel { HomeViewModel(get()) }
//    viewModel { TvViewModel(get()) }
//    viewModel { DetailMovieViewModel(get()) }
//    viewModel { DetailTvViewModel(get()) }
//    viewModel { MovieFavoriteViewModel(get()) }
//    viewModel { TvFavoriteViewModel(get()) }
//}

@Module
abstract class PresentationModule{
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(viewModel: HomeViewModel): ViewModel
    
    @Binds
    @IntoMap
    @ViewModelKey(TvViewModel::class)
    abstract fun bindsTvViewModel(viewModel: TvViewModel): ViewModel
    
    @Binds
    @IntoMap
    @ViewModelKey(DetailMovieViewModel::class)
    abstract fun bindsDetailMovieViewModel(viewModel: DetailMovieViewModel): ViewModel
    
    @Binds
    @IntoMap
    @ViewModelKey(DetailTvViewModel::class)
    abstract fun bindsDetailTvViewModel(viewModel: DetailTvViewModel): ViewModel
    
    @Binds
    @IntoMap
    @ViewModelKey(MovieFavoriteViewModel::class)
    abstract fun bindsMovieFavoriteViewModel(viewModel: MovieFavoriteViewModel): ViewModel
    
    @Binds
    @IntoMap
    @ViewModelKey(TvFavoriteViewModel::class)
    abstract fun bindsTvFavoriteViewModel(viewModel: TvFavoriteViewModel): ViewModel
    
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}