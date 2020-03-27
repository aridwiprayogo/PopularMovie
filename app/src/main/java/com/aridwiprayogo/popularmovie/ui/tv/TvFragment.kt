package com.aridwiprayogo.popularmovie.ui.tv

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
import com.aridwiprayogo.popularmovie.domain.model.TvMovie
import com.aridwiprayogo.popularmovie.utils.gone
import com.aridwiprayogo.popularmovie.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_tv.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvFragment : Fragment() {

    private val listTvMovie = mutableListOf<TvMovie>()
    private val viewModel: TvViewModel? by viewModel()
    private lateinit var tvAdapter: TvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel
        viewModel?.run {
            listTvMovieData().observe(this@TvFragment, listTvMovieObserver)
            getLoading().observe(this@TvFragment, loadingObserver)
            getError().observe(this@TvFragment, errorObserver)
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
