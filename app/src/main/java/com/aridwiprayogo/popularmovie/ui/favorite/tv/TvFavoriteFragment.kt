package com.aridwiprayogo.popularmovie.ui.favorite.tv

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.ui.tv.TvAdapter
import kotlinx.android.synthetic.main.tv_favorite_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvFavoriteFragment : Fragment(R.layout.tv_favorite_fragment) {
    companion object {
        fun newInstance() = TvFavoriteFragment()
    }

    private val viewModel by viewModel< TvFavoriteViewModel>()
    private lateinit var tvAdapter: TvAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTvFavorite().observe(viewLifecycleOwner, Observer { listTvFavorite ->
            tvAdapter = TvAdapter(listTvFavorite) { tvMovie->
                val action =
                    TvFavoriteFragmentDirections.actionTvFavoriteFragmentToDetailTvFragment(tvMovie)
                findNavController().navigate(action)
            }

            rv_list_tv_favorite.apply {
                adapter = tvAdapter
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
            }
            
            tvAdapter.notifyDataSetChanged()

        })
    }
}
