package android.thortechasia.popularmovie.di

import android.arch.persistence.room.Room
import android.thortechasia.popularmovie.data.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val roomModule = module {
    single { Room.databaseBuilder(androidApplication(), AppDatabase::class.java,"movie_db").build() }
    single { get<AppDatabase>().popularMovieDao() }
}