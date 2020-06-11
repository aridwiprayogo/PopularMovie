package com.aridwiprayogo.popularmovie.di

import com.aridwiprayogo.popularmovie.data.MovieRepositoryImpl
import com.aridwiprayogo.popularmovie.data.TvRepositoryImpl
import com.aridwiprayogo.popularmovie.domain.repository.MovieRepository
import com.aridwiprayogo.popularmovie.domain.repository.TvRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun bindTvRepository(tvRepository: TvRepositoryImpl): TvRepository
}