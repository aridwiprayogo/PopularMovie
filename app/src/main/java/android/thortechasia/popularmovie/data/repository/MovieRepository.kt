package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.PopularMovie
import android.thortechasia.popularmovie.data.local.PopularMovieTable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MovieRepository(
    val remoteDataSource: RemoteMovieDataSource,
    val localDataSource: LocalDataSource
) : MovieDataSource {

    override fun getPopularMovie(): Single<List<PopularMovie>> {
        return localDataSource.getPopularMovie()
            .map { list->
                list.map { PopularMovie.from(it) }
            }
            .flatMap {
                if (it.isEmpty())getPopularFromRemote() else
                    Single.just(it)
            }
            .doAfterSuccess {
                getPopularFromRemote()
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        Timber.d("refresh data")
                    },{
                        Timber.e(it)
                    })
            }
    }

    private fun getPopularFromRemote(): Single<List<PopularMovie>>? {
        return remoteDataSource.getPopularMovie()
            .doOnSuccess {
                lokalMovieDataSource.savePopularMovies(it.movies.map { movie ->
                    PopularMovieEntity.from(movie)
                })
            }
            .map { list->
                list.movies.map { PopularMovie.from(it) }
            }
    }

    override fun addPopularMovies(movies: List<PopularMovieTable>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}