package com.aridwiprayogo.popularmovie.di

//import androidx.room.Room
//import com.aridwiprayogo.popularmovie.data.local.PopularMovieDatabase
//import com.aridwiprayogo.popularmovie.data.remote.ApiClient
//import org.koin.android.ext.koin.androidContext
//import org.koin.core.scope.Scope
//import org.koin.dsl.module
//
//const val DATABASE_NAME = "Popular Movie"
//val appModule = module {
//    factory { ApiClient.create() }
//    factory { popularMovieDatabase().movieDao() }
//    factory { popularMovieDatabase().tvDao() }
//}
//
//private fun Scope.popularMovieDatabase() =
//    Room.databaseBuilder(androidContext(), PopularMovieDatabase::class.java, DATABASE_NAME).build()
import android.content.Context
import androidx.room.Room
import com.aridwiprayogo.popularmovie.data.local.PopularMovieDatabase
import com.aridwiprayogo.popularmovie.data.local.movie.MovieDao
import com.aridwiprayogo.popularmovie.data.local.tv.TvDao
import com.aridwiprayogo.popularmovie.data.remote.ApiClient
import com.aridwiprayogo.popularmovie.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

const val DATABASE_NAME = "Popular Movie"
@Module
@InstallIn(ApplicationComponent::class)
class AppModule{
    @Provides
    @Singleton
    fun provideRetrofit(): ApiService = ApiClient.create()

    @Provides
    @Singleton
    fun provideMovieDao(@ApplicationContext context: Context): MovieDao =
        popularMovieDatabase(context).movieDao()
    @Provides
    @Singleton
    fun provideTvDao(@ApplicationContext context: Context): TvDao =
        popularMovieDatabase(context).tvDao()

    private fun popularMovieDatabase(context: Context) =
        Room.databaseBuilder(context, PopularMovieDatabase::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
}