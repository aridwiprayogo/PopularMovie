package android.thortechasia.popularmovie.ui.movie

import android.thortechasia.popularmovie.data.repository.MovieRepository
import android.thortechasia.popularmovie.domain.model.PopularMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MoviePresenterTest {

    private lateinit var presenter: MoviePresenter
    @Mock
    lateinit var repository: MovieRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = MoviePresenter(repository,TestDispatcherProvider())
    }

    @Test
    fun getPopularMovies() {
        runBlocking {
            val movieList = listOf(mock(PopularMovie::class.java))
            //given
            given(repository.getPopularMoviesAsync()).willReturn(movieList)

            //when
            presenter.getPopularMovies()

            //then
            verify(repository).getPopularMoviesAsync()
        }

    }

    @Test
    fun testGetPopularMoviesFailed() {
        val throwable = Throwable("something error")

        runBlocking {

            given(repository.getPopularMoviesAsync()).willThrow(withContext(Dispatchers.Default) { throwable })
            presenter.getPopularMovies()
            Mockito.verify(repository).getPopularMoviesAsync()
        }


        /*Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).failureGetPopularMovies(throwable)
        Mockito.verify(view, Mockito.never()).showPopularMovies(MockitoKotlinHelper.any())*/
    }
}