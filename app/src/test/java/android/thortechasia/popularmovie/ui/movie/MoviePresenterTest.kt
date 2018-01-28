package android.thortechasia.popularmovie.ui.movie

import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.domain.model.PopularMovie
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class MoviePresenterTest{

    private lateinit var presenter: MoviePresenter
    @Mock
    lateinit var repository: MovieRepository

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        presenter = MoviePresenter(repository)
    }

    @Test
    fun getPopularMovies(){
        val movieList = listOf(mock(PopularMovie::class.java))
        runBlocking {
            //given
            suspend { given(repository.getPopularMoviesAsync()).willReturn(async { movieList }) }

            //when
            suspend { presenter.getPopularMovies() }

            //then
            suspend { Mockito.verify(repository).getPopularMoviesAsync().await() }
        }

    }

    @Test
    fun testGetPopularMoviesFailed(){
        val throwable = Throwable("something error")

        runBlocking {

            given(repository.getPopularMoviesAsync()).willThrow(async { throwable }.await())
            presenter.getPopularMovies()
            Mockito.verify(repository).getPopularMoviesAsync().await()
        }


        /*Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).failureGetPopularMovies(throwable)
        Mockito.verify(view, Mockito.never()).showPopularMovies(MockitoKotlinHelper.any())*/
    }
}