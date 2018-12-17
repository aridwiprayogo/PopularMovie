package android.thortechasia.popularmovie.ui.movie

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.utils.gone
import android.thortechasia.popularmovie.utils.visible
import android.thortechasia.popularmovie.data.PopularMovie
import android.thortechasia.popularmovie.ui.detail.DetailActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie.*
import org.koin.android.ext.android.inject

class MovieActivity : AppCompatActivity(), MovieContract.View {


    private lateinit var movieAdapter: MovieAdapter
    private val movieList: MutableList<PopularMovie> = mutableListOf()

    private val presenter: MoviePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        onAttachView()
        initRv()
        presenter.getPopularMovies()

    }

    override fun showPopularMovies(movies: List<PopularMovie>) {
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

    override fun failureGetPopularMovies(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    fun initRv() {

        val lambda : (PopularMovie) -> Unit = {
            Toast.makeText(this@MovieActivity, it.title,
            Toast.LENGTH_SHORT).show()

            startActivity(Intent(this@MovieActivity, DetailActivity::class.java)
                .putExtra("ID", it.id))
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
