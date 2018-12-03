package android.thortechasia.popularmovie.ui.movie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.Utils.Injector
import android.thortechasia.popularmovie.data.PopularMovieModel
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity(), MovieContract.View {

    private lateinit var movieAdapter: MovieAdapter
    private val movieList: MutableList<PopularMovieModel.Movies> = mutableListOf()
    private lateinit var presenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        presenter = Injector.provideMoviePresenter()
        onAttachView()
        initRv()
        presenter.getPopularMovies()

    }

    override fun showPopularMovies(movies: List<PopularMovieModel.Movies>) {
        movieList.addAll(movies)
        movieAdapter.notifyDataSetChanged()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    fun initRv() {

        val lambda : (PopularMovieModel.Movies) -> Unit = {
            Toast.makeText(this@MovieActivity, it.title,
            Toast.LENGTH_SHORT).show()
        }

        movieAdapter = MovieAdapter(movieList, lambda)
        rvPopularMovies.apply {
            layoutManager = GridLayoutManager(this@MovieActivity, 3)
            adapter = movieAdapter
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
