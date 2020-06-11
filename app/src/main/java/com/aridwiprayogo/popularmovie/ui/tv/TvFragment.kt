package com.aridwiprayogo.popularmovie.ui.tv

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.domain.model.TvMovie
import com.aridwiprayogo.popularmovie.ui.BaseFragment
import com.aridwiprayogo.popularmovie.utils.gone
import com.aridwiprayogo.popularmovie.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_tv.*

@AndroidEntryPoint
class TvFragment : BaseFragment(R.layout.fragment_tv) {

    private val listTvMovie = mutableListOf<TvMovie>()
    private val viewModel: TvViewModel? by viewModels()
    private lateinit var tvAdapter: TvAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel
        viewModel?.run {
            listTvMovieData().observe(viewLifecycleOwner, listTvMovieObserver)
            getLoading().observe(viewLifecycleOwner, loadingObserver)
            getError().observe(viewLifecycleOwner, errorObserver)
            getTvMovie()
        }
    }

    private val listTvMovieObserver = Observer<List<TvMovie>> { tvMovie ->
        listTvMovie.addAll(tvMovie)
        tvAdapter = TvAdapter(listTvMovie) { movie ->
            val action =
                TvFragmentDirections.actionFromTvFragmentToDetailFragment(movie)
            findNavController().navigate(action)
        }

        rv_list_tv.apply {
            adapter = tvAdapter
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
        }
        tvAdapter.notifyDataSetChanged()
    }
    private val loadingObserver = Observer<Boolean> { loading ->
        when (loading) {
            true -> {
                activity?.progress_circular?.visible()
            }
            false -> {
                activity?.progress_circular?.gone()
            }
        }
    }
    private val errorObserver = Observer<Exception> { error ->
        Toast.makeText(context, error.localizedMessage, Toast.LENGTH_SHORT).show()
    }
}
