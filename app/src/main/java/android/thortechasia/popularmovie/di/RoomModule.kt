package android.thortechasia.popularmovie.di

import android.thortechasia.popularmovie.data.lokal.AppDatabase
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val roomModule = module {

    single { Room.databaseBuilder(androidApplication(),AppDatabase::class.java,
        "movie_db").build() }

    single { get<AppDatabase>().popularMovieDao() }

}