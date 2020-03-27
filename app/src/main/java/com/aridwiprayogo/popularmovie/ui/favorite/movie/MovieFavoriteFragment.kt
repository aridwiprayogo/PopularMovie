package com.aridwiprayogo.popularmovie.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.ui.movie.HomeFragmentDirections
import com.aridwiprayogo.popularmovie.ui.movie.PopularMovieAdapter
import kotlinx.android.synthetic.main.movie_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFavoriteFragment : Fragment() {

    companion object {
        fun newInstance() = MovieFavoriteFragment()
    }

    private  val favoriteViewModel by viewModel<MovieFavoriteViewModel>()
    private lateinit var movieAdapter: PopularMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

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
