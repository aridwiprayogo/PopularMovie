package android.thortechasia.popularmovie.Utils

import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.data.repository.RemoteMovieDataSource
import android.thortechasia.popularmovie.network.ApiClient
import android.thortechasia.popularmovie.ui.movie.MoviePresenter
import io.reactivex.disposables.CompositeDisposable

object Injector {

    fun provideMoviePresenter() = MoviePresenter(getMovieRepository(), getCompositeDisposable())

    fun getCompositeDisposable() = CompositeDisposable()
    fun getMovieRepository() = MovieRepository.getInstance(provideRemoteMovieDataSource())

    fun provideRemoteMovieDataSource() = RemoteMovieDataSource(provideApiService())

    fun provideApiService() = ApiClient.create()

}