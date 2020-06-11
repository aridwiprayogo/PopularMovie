package com.aridwiprayogo.popularmovie.ui.favorite.tv

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.ui.BaseFragment
import com.aridwiprayogo.popularmovie.ui.tv.TvAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.tv_favorite_fragment.*

@AndroidEntryPoint
class TvFavoriteFragment : BaseFragment(R.layout.tv_favorite_fragment) {
    companion object {
        fun newInstance() = TvFavoriteFragment()
    }

    private val viewModel by viewModels< TvFavoriteViewModel>()
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
