package android.thortechasia.popularmovie.ui.detail

import android.os.Bundle
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.ui.movie.MovieActivity
import android.thortechasia.popularmovie.utils.Constants
import android.thortechasia.popularmovie.utils.loadImage
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity(){

    private val presenter : DetailPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail Movie"

        presenter.movie().observe(this, Observer<PopularMovie> {
            txt_title.text = it?.title
            image.loadImage("${Constants.BASE_IMAGE_URL}${it?.image.toString()}")
            txt_description.text = it?.desc
        })

        val id = intent.getIntExtra(MovieActivity.ID_KEY, 0)
        presenter.getDetailMovie(id)
    }

}
