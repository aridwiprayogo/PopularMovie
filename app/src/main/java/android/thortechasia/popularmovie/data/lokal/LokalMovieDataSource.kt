package android.thortechasia.popularmovie.data.lokal

import kotlinx.coroutines.Deferred

class LokalMovieDataSource(private val popularMovieDao: PopularMovieDao) {

    fun getPopularMovies(): Deferred<List<PopularMovieEntity>> {
        return popularMovieDao.getPopularMovies()
    }

    fun savePopularMovies(movies: List<PopularMovieEntity>){
        popularMovieDao.inserts(movies)
    }

    fun getDetailMovie(id: Int) : Deferred<PopularMovieEntity>{
        return popularMovieDao.getDetailMovie(id)
    }

}