package android.thortechasia.popularmovie.ui.movie

import android.content.Intent
import android.os.Bundle
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.ui.detail.DetailActivity
import android.thortechasia.popularmovie.utils.gone
import android.thortechasia.popularmovie.utils.visible
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_movie.*
import org.koin.android.ext.android.inject

class MovieActivity : AppCompatActivity() {


    private lateinit var movieAdapter: MovieAdapter
    private val movieList: MutableList<PopularMovie> = mutableListOf()

    private val presenter: MoviePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        initRv()
        presenter.getPopularMovies()
        presenter.movie().observe(this, Observer { list ->
            list?.let { showPopularMovies(it) }
        })
        presenter.error().observe(this, Observer { throwable ->
            throwable?.let { failureGetPopularMovies(it) }
        })

        presenter.loading().observe(this, Observer { progress ->
            when(progress){
                true-> showLoading()
                false -> hideLoading()
            }
        })
    }

    private fun showPopularMovies(movies: List<PopularMovie>) {
        movieList.addAll(movies)
        movieAdapter.notifyDataSetChanged()
    }


    private fun showLoading() {
        progressBar.visible()
    }

    private fun hideLoading() {
        progressBar.gone()
    }

    private fun failureGetPopularMovies(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    private fun initRv() {

        movieAdapter = MovieAdapter(movieList, listener = {
            Toast.makeText(this@MovieActivity, it.title, Toast.LENGTH_SHORT).show()

            startActivity(
                Intent(this@MovieActivity, DetailActivity::class.java)
                    .putExtra(ID_KEY, it.id)
            )
        })
        rvPopularMovies.apply {
            layoutManager = androidx.recyclerview.widget.GridLayoutManager(this@MovieActivity, 3)
            adapter = movieAdapter
        }
    }

    companion object {
        const val ID_KEY = "ID"
    }
}
