package android.thortechasia.popularmovie.data.lokal

import kotlinx.coroutines.Deferred

class LokalMovieDataSource(private val popularMovieDao: PopularMovieDao) {

    suspend fun getPopularMovies(): Deferred<List<PopularMovieEntity>> {
        return async{popularMovieDao.getPopularMoviesAsync()}
    }

    fun savePopularMovies(movies: List<PopularMovieEntity>){
        popularMovieDao.inserts(movies)
    }

    suspend fun getDetailMovieAsync(id: Int) : Deferred<PopularMovieEntity>{
        return async{popularMovieDao.getDetailMovieAsync(id)}
    }

}