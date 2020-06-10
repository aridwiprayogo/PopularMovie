package com.aridwiprayogo.popularmovie.di

import com.aridwiprayogo.popularmovie.MainActivity
import com.aridwiprayogo.popularmovie.ui.detail_movie.DetailMovieFragment
import com.aridwiprayogo.popularmovie.ui.detail_tv.DetailTvFragment
import com.aridwiprayogo.popularmovie.ui.favorite.movie.MovieFavoriteFragment
import com.aridwiprayogo.popularmovie.ui.favorite.tv.TvFavoriteFragment
import com.aridwiprayogo.popularmovie.ui.movie.HomeFragment
import com.aridwiprayogo.popularmovie.ui.tv.TvFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity()           : MainActivity
    @ContributesAndroidInjector
    abstract fun contributeMovieFragment()          : HomeFragment
    @ContributesAndroidInjector
    abstract fun contributeTvFragment()             : TvFragment
    @ContributesAndroidInjector
    abstract fun contributeTvFavoriteFragment()     : TvFavoriteFragment
    @ContributesAndroidInjector
    abstract fun contributeMovieFavoriteFragment()  : MovieFavoriteFragment
    @ContributesAndroidInjector
    abstract fun contributeDetailTvFragment()       : DetailTvFragment
    @ContributesAndroidInjector
    abstract fun contributeDetailMovieFragment()    : DetailMovieFragment
}