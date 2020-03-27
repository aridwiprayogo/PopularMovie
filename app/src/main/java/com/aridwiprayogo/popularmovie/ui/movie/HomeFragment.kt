package com.aridwiprayogo.popularmovie.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.domain.model.PopularMovie
import com.aridwiprayogo.popularmovie.utils.gone
import com.aridwiprayogo.popularmovie.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel? by viewModel()
    private val listPopularMovie = mutableListOf<PopularMovie>()

    private var adapterMovie: PopularMovieAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel

        viewModel?.run {
            getPopularMovieData().observe(viewLifecycleOwner, ::popularMovieObserver.invoke())
            getLoading().observe(viewLifecycleOwner, ::getLoadingObserver.invoke())
            getError().observe(viewLifecycleOwner, ::errorObserver.invoke())
            getPopularMovie()
        }

    }

    private val popularMovieObserver = Observer<List<PopularMovie>> { movie ->
        listPopularMovie.addAll(movie)
        adapterMovie = PopularMovieAdapter(listPopularMovie) { popularMovie ->
            val action =
                HomeFragmentDirections.actionFromHomeFragmentToDetailFragment(popularMovie)
            findNavController().navigate(action)
        }
        rv_list_movie.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = adapterMovie
            setHasFixedSize(true)
        }
        adapterMovie?.notifyDataSetChanged()
    }

    private fun getLoadingObserver() =
        Observer<Boolean> { loading ->
        when (loading) {
            true -> { activity?.progress_circular?.visible() }
            false -> { activity?.progress_circular?.gone() }
        }
    }

    private val errorObserver = Observer<Exception> {
        Toast.makeText(context, it.localizedMessage, Toast.LENGTH_SHORT).show()
    }

}
