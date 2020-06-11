package com.aridwiprayogo.popularmovie.ui.detail_movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.domain.model.PopularMovie
import com.aridwiprayogo.popularmovie.ui.BaseFragment
import com.aridwiprayogo.popularmovie.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*

@AndroidEntryPoint
class DetailMovieFragment : BaseFragment(R.layout.fragment_detail), AppBarConfiguration.OnNavigateUpListener {

    private val args by navArgs<DetailMovieFragmentArgs>()
    private lateinit var popularMovie: PopularMovie
    private val viewModel by viewModels<DetailMovieViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.actionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popularMovie = args.popularMovie
        bindMovie()
        imageView_movie_favorite.setOnClickListener {_->
            viewModel.saveFavorite(popularMovie)
        }
    }

    override fun onNavigateUp() = findNavController().navigateUp()

    private fun bindMovie() = popularMovie.let {
        tv_movie_title.text = it.title
        tv_movie_rating.text = it.voteAverage.toString()
        tv_movie_overview.text = it.overview
        tv_movie_release_date.text = it.releaseDate
        iv_movie_poster.loadImage(it.src)
        iv_movie_backdrop.loadImage(it.backdropPath)
        tv_movie_vote_count.text = it.voteCount.toString()
    }
}
