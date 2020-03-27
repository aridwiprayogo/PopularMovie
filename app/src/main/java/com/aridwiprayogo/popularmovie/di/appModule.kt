package com.aridwiprayogo.popularmovie.di

import androidx.room.Room
import com.aridwiprayogo.popularmovie.data.local.PopularMovieDatabase
import com.aridwiprayogo.popularmovie.data.remote.ApiClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope
import org.koin.dsl.module

const val DATABASE_NAME = "Popular Movie"
val appModule = module {
    factory(definition = { ApiClient.create() })
    factory(definition = { popularMovieDatabase().movieDao() })
    factory(definition = { popularMovieDatabase().tvDao() })
}

private fun Scope.popularMovieDatabase() =
    Room.databaseBuilder(androidContext(), PopularMovieDatabase::class.java, DATABASE_NAME).build()