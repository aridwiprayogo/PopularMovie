package android.thortechasia.popularmovie.ui.movie

import android.content.Intent
import android.os.Bundle
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.ui.detail.MovieDetailFragment
import android.thortechasia.popularmovie.utils.gone
import android.thortechasia.popularmovie.utils.visible
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.inject
import timber.log.Timber
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.movie_list.*

class MovieListFragment : Fragment() {
    private lateinit var movieAdapter: MovieAdapter
    private val movieList: MutableList<PopularMovie> = mutableListOf()

    private val presenter: MoviePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.getPopularMovies()
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.movie_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        presenter.movie().observe(this, Observer { list ->
            list?.let { showPopularMovies(it) }
        })
        presenter.error().observe(this, Observer { throwable ->
            throwable?.let { failureGetPopularMovies(it) }
        })

        presenter.loading().observe(this, Observer { progress ->
            when (progress) {
                true -> showLoading()
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
        Toast.makeText(requireContext(), throwable.message, Toast.LENGTH_SHORT).show()
        Timber.e(throwable)
    }

    private fun initRv() {
        movieAdapter = MovieAdapter(movieList, listener = { movie ->
            Toast.makeText(requireContext(), movie.title, Toast.LENGTH_SHORT).show()

            val action = MovieListFragmentDirections.showMovieDetailFragment(movie)
            findNavController().navigate(action)
        })
        rvPopularMovies.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = movieAdapter
        }
    }

    companion object {
        const val ID_KEY = "ID"
    }
}
