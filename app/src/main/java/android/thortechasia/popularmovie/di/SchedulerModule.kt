package android.thortechasia.popularmovie.di

import android.thortechasia.popularmovie.utils.AppDispatcherProvider
import android.thortechasia.popularmovie.utils.DispatcherProvider
import org.koin.dsl.module.module

val schedulerModule = module {

    single<DispatcherProvider> { AppDispatcherProvider() }
}