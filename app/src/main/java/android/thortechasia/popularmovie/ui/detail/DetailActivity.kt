package android.thortechasia.popularmovie.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.utils.Constants
import android.thortechasia.popularmovie.utils.loadImage
import android.thortechasia.popularmovie.data.PopularMovie
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity(),  DetailContract.View {

    private val presenter : DetailPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail Movie"

        onAttachView()
        val id = intent.getIntExtra("ID", 0)
        presenter.getDetailMovie(id)
    }

    override fun showDetail(movie: PopularMovie) {
        image.loadImage(this,"${Constants.BASE_IMAGE_URL}${movie.image}")
        txt_title.text = movie.title
        txt_description.text = movie.desc
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    override fun onDestroy() {
        onDetachView()
        super.onDestroy()
    }
}
