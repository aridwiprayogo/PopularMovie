package android.thortechasia.popularmovie.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.Utils.gone
import android.thortechasia.popularmovie.Utils.visible
import android.thortechasia.popularmovie.data.PopularMovie
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() /*MainContract.View*/ {

    private lateinit var movieAdapter: MovieAdapter
    //    private val movieList : MutableList<PopularMovieModel.Movies> = mutableListOf()
    private val presenter: MoviePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        onAttachView()
        progressBar.visible()

        presenter.getDataPopularMovie()?.observe(this, Observer { movieList ->

            movieList?.let {
                initRv(it)
                progressBar.gone()
            }
        })
        presenter.getPopularMovie()
    }

    /*override fun showPopularMovie(movies: List<PopularMovieModel.Movies>) {
        movieList.addAll(movies)
        movieAdapter.notifyDataSetChanged()
    }*/
    private fun initRv(movieList: List<PopularMovie>) {
        movieAdapter = MovieAdapter(movieList)

        rvPopularMovies.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = movieAdapter
        }

    }

    /*override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }*/

    /*override fun onDestroy() {
//        compositeDisposable.clear()
        super.onDestroy()
//        presenter.onDetach()
    }*/
}
