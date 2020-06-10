package com.aridwiprayogo.popularmovie.ui

import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment

abstract class BaseFragment(@LayoutRes fragment: Int) : DaggerFragment(fragment)