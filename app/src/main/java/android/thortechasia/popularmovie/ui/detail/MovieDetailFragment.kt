package android.thortechasia.popularmovie.ui.detail

import android.os.Bundle
import android.thortechasia.popularmovie.R
import android.thortechasia.popularmovie.domain.model.PopularMovie
import android.thortechasia.popularmovie.utils.Constants
import android.thortechasia.popularmovie.utils.loadImage
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.movie_detail.*
import org.koin.android.ext.android.inject

class MovieDetailFragment: Fragment(){
    private val presenter : DetailPresenter by inject()
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.movie_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().actionBar?.title = "Detail Movie"

        val movie = args.movie
        txt_title.text = movie.title
        image.loadImage("${Constants.BASE_IMAGE_URL}${movie.image}")
        txt_description.text = movie.desc
    }
}
