package android.thortechasia.popularmovie.di

import android.thortechasia.popularmovie.data.repository.LokalMovieDataSource
import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.data.repository.RemoteMovieDataSource
import org.koin.dsl.module.module

val dataModule = module {

    single { RemoteMovieDataSource(get()) }

    single { LokalMovieDataSource(get()) }

    single { MovieRepository(get(), get()) }

}