package android.thortechasia.popularmovie.di

import android.thortechasia.popularmovie.ui.main.MoviePresenter
import org.koin.dsl.module.module

val presenterModule = module {
    factory { MoviePresenter(get(), get()) }
}