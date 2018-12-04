package android.thortechasia.popularmovie.ui.movie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.Utils.gone
import android.thortechasia.popularmovie.Utils.visible
import android.thortechasia.popularmovie.data.PopularMovieModel
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie.*
import org.koin.android.ext.android.inject

class MovieActivity : AppCompatActivity(), MovieContract.View {

    private lateinit var movieAdapter: MovieAdapter
    private val movieList: MutableList<PopularMovieModel.Movies> = mutableListOf()

    private val presenter: MoviePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

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

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.gone()
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
