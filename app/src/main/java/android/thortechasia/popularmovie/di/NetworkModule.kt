package android.thortechasia.popularmovie.di

import android.thortechasia.popularmovie.network.ApiClient
import org.koin.dsl.module.module

val networkModule = module {

    single { ApiClient().create() }

}