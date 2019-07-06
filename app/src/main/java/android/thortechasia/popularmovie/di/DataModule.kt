package android.thortechasia.popularmovie.di

import android.thortechasia.popularmovie.data.lokal.LocalMovieDataSource
import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.data.remote.RemoteMovieDataSource
import org.koin.dsl.module.module

val dataModule = module {

    single { RemoteMovieDataSource(get()) }

    single { LocalMovieDataSource(get()) }

    single { MovieRepository(get(), get()) }

}