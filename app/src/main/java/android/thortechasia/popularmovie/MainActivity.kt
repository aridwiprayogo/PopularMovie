package android.thortechasia.popularmovie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.thortechasia.popularmovie.data.PopularMovieModel
import android.thortechasia.popularmovie.network.ApiClient
import android.thortechasia.popularmovie.network.ApiService
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter : MovieAdapter
    private val movieList : MutableList<PopularMovieModel.Movies> = mutableListOf()
    private lateinit var apiService: ApiService
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRv()
        apiService = ApiClient.create()
        getPopularMovies()

    }

    fun initRv(){
        movieAdapter = MovieAdapter(movieList)
        rvPopularMovies.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = movieAdapter
        }
    }

    fun getPopularMovies() {
        compositeDisposable.add(apiService.getPopularMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    movieList.addAll(it.movies)
                    movieAdapter.notifyDataSetChanged()
                },
                {
                    Log.e(MainActivity::class.java.simpleName, it.message)
                })
        )
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
