package android.thortechasia.popularmovie.data.lokal

class LokalMovieDataSource(private val popularMovieDao: PopularMovieDao) {

    suspend fun getPopularMovies(): List<PopularMovieEntity> {
        return popularMovieDao.getPopularMoviesAsync()
    }

    fun savePopularMovies(movies: List<PopularMovieEntity>){
        popularMovieDao.inserts(movies)
    }

    suspend fun getDetailMovieAsync(id: Int) : PopularMovieEntity {
        return popularMovieDao.getDetailMovieAsync(id)
    }

}