package android.thortechasia.popularmovie.ui.movie

import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.data.repository.MovieRepository
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
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
    @Mock
    lateinit var view: MovieContract.View


    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        presenter = MoviePresenter(repository, CompositeDisposable(),TestSchedulerProvider())
        presenter.onAttach(view)
    }

    @Test
    fun getPopularMovies(){
        //given
        val movieList = listOf(mock(PopularMovie::class.java))
        given(repository.getPopularMoviesAsync()).willReturn(Single.just(movieList))
        //when
        presenter.getPopularMovies()
        //then
        Mockito.verify(view).showLoading()
        Mockito.verify(repository).getPopularMoviesAsync()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showPopularMovies(movieList)
        Mockito.verify(view, Mockito.never()).failureGetPopularMovies(MockitoKotlinHelper.any())
    }

    @Test
    fun testGetPopularMoviesFailed(){
        val throwable = Throwable("something error")
        given(repository.getPopularMoviesAsync()).willReturn(Single.error(throwable))

        presenter.getPopularMovies()

        Mockito.verify(view).showLoading()
        Mockito.verify(repository).getPopularMoviesAsync()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).failureGetPopularMovies(throwable)
        Mockito.verify(view, Mockito.never()).showPopularMovies(MockitoKotlinHelper.any())
    }
}