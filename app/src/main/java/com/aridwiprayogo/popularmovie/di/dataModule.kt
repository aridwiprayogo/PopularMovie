package com.aridwiprayogo.popularmovie.di

import com.aridwiprayogo.popularmovie.data.MovieRepositoryImpl
import com.aridwiprayogo.popularmovie.data.TvRepositoryImpl
import com.aridwiprayogo.popularmovie.data.local.LocalDataSource
import com.aridwiprayogo.popularmovie.data.local.movie.LocalMovieDataSource
import com.aridwiprayogo.popularmovie.data.local.movie.LocalMovieDataSourceImpl
import com.aridwiprayogo.popularmovie.data.local.movie.MovieEntity
import com.aridwiprayogo.popularmovie.data.local.tv.LocalTvDataSource
import com.aridwiprayogo.popularmovie.data.local.tv.LocalTvDataSourceImpl
import com.aridwiprayogo.popularmovie.data.local.tv.TvEntity
import com.aridwiprayogo.popularmovie.data.remote.RemoteDataSource
import com.aridwiprayogo.popularmovie.data.remote.RemoteDataSourceImpl
import com.aridwiprayogo.popularmovie.domain.repository.MovieRepository
import com.aridwiprayogo.popularmovie.domain.repository.TvRepository
import org.koin.dsl.module

val dataModule = module {
    factory<LocalMovieDataSource> { LocalMovieDataSourceImpl(get()) }
    factory<LocalTvDataSource> { LocalTvDataSourceImpl(get()) }
    factory<RemoteDataSource>{ RemoteDataSourceImpl(get()) }
    single<MovieRepository>{ MovieRepositoryImpl(get(),get()) }
    single<TvRepository>{TvRepositoryImpl(get(),get())}

}
