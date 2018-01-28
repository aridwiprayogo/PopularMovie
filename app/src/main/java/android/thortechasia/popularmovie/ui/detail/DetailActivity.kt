package android.thortechasia.popularmovie.ui.detail

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.ui.movie.MovieActivity
import android.thortechasia.popularmovie.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity(){

    private val presenter : DetailPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail Movie"

        presenter.movie().observe(this, Observer<PopularMovie> {
            textView.text = it?.title
            image.loadImage(it?.image.toString())
            textView3.text = it?.desc
        })

        val id = intent.getIntExtra(MovieActivity.ID_KEY, 0)
        presenter.getDetailMovie(id)
    }

}
