package android.thortechasia.popularmovie.di

import android.thortechasia.popularmovie.data.repository.LocalDataSource
import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.data.repository.RemoteMovieDataSource
import org.koin.dsl.module.module

val dataModule = module {
    single { RemoteMovieDataSource(get()) }
    single { LocalDataSource(get()) }
    single { MovieRepository(get(),get()) }
}