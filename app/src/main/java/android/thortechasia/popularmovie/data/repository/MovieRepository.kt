package android.thortechasia.popularmovie.data.repository

import android.thortechasia.popularmovie.data.PopularMovie
import android.thortechasia.popularmovie.data.local.PopularMovieTable
import io.reactivex.Single

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
    }

    private fun getPopularFromRemote(): Single<List<PopularMovie>>? {
        return remoteDataSource.getPopularMovie()
            .map { list->
                list.movies.map { PopularMovie.from(it) }
            }
    }

    override fun addPopularMovies(movies: List<PopularMovieTable>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}