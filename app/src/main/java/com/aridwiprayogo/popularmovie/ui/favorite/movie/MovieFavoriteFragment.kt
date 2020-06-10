package com.aridwiprayogo.popularmovie.ui.favorite.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.ui.BaseFragment
import com.aridwiprayogo.popularmovie.ui.movie.PopularMovieAdapter
import kotlinx.android.synthetic.main.movie_favorite_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFavoriteFragment : BaseFragment(R.layout.movie_favorite_fragment) {

    companion object {
        fun newInstance() = MovieFavoriteFragment()
    }

    private  val favoriteViewModel by viewModel<MovieFavoriteViewModel>()
    private lateinit var movieAdapter: PopularMovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.favoriteViewModel.getMovieFavorite().observe(viewLifecycleOwner, Observer { list ->
            movieAdapter = PopularMovieAdapter(list) { popularMovie ->
                val action =
                    MovieFavoriteFragmentDirections.actionMovieFavoriteFragmentToDetailFragment(popularMovie)
                findNavController().navigate(action)
            }

            rv_list_movie_favorite.apply {
                adapter = movieAdapter
                layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
                setHasFixedSize(true)
            }

            movieAdapter.notifyDataSetChanged()
        })
    }
}
