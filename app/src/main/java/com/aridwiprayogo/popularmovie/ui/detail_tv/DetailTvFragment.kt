package com.aridwiprayogo.popularmovie.ui.detail_tv

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.domain.model.TvMovie
import com.aridwiprayogo.popularmovie.utils.loadImage
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.content_detail_tv.*
import kotlinx.android.synthetic.main.detail_tv_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class DetailTvFragment : Fragment() {
    private val viewModel by viewModel<DetailTvViewModel>()
    private val args: DetailTvFragmentArgs by navArgs()
    private lateinit var tvMovie: TvMovie
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_tv_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvMovie = args.tvMovie
        bindView(tvMovie)
        imageView_tv_favorite.run {
            setOnClickListener {
                this.loadImage(R.drawable.ic_favorite)
                viewModel.run {
                    saveFavorite(tvMovie = tvMovie)
                }
            }
        }
    }

    private fun bindView(tvMovie: TvMovie) {
        textView_Title.text = tvMovie.title
        textView_release_date.text = tvMovie.release_date
        textView_overview.text = tvMovie.overview
        textView_rating.text = tvMovie.vote_average.toString()
        textView_vote_count.text = String.format(Locale.getDefault(),"(${tvMovie.vote_count})")
        imageView_tv_poster.loadImage(tvMovie.image)
        imageView_tv_backdrop.loadImage(tvMovie.image)
    }

}