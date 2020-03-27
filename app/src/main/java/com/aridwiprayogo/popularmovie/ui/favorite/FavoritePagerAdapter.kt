package com.aridwiprayogo.popularmovie.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.aridwiprayogo.popularmovie.R
import com.aridwiprayogo.popularmovie.ui.favorite.movie.MovieFavoriteFragment
import com.aridwiprayogo.popularmovie.ui.favorite.tv.TvFavoriteFragment

class FavoritePagerAdapter(
    private val ctx: Context,
    fm: FragmentManager
): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private lateinit var mFragment: Fragment
    override fun getItem(position: Int): Fragment {
        when(position){
            0-> mFragment = MovieFavoriteFragment.newInstance()
            1-> mFragment = TvFavoriteFragment.newInstance()
        }
        return mFragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return ctx.resources.getString(TAB_TITLES[position])
    }

    override fun getCount() = 2

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_title_favorite_movie, R.string.tab_title_favorite_tv)
    }
}