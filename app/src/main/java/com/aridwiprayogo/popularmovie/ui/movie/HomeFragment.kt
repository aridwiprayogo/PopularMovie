package com.aridwiprayogo.popularmovie.ui.movie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.domain.model.PopularMovie
import com.aridwiprayogo.popularmovie.ui.BaseFragment
import com.aridwiprayogo.popularmovie.utils.gone
import com.aridwiprayogo.popularmovie.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_fragment.*

@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.home_fragment) {
    private val viewModel: HomeViewModel? by viewModels()

    private var adapterMovie: PopularMovieAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel

        viewModel?.run {
            popularMovieData.observe(viewLifecycleOwner, ::popularMovieObserver.invoke())
            loading.observe(viewLifecycleOwner, ::getLoadingObserver.invoke())
            error.observe(viewLifecycleOwner, ::errorObserver.invoke())
            getPopularMovie()
        }

    }

    private val popularMovieObserver = Observer<List<PopularMovie>> { movie ->

        adapterMovie = PopularMovieAdapter(movie) { popularMovie ->
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
