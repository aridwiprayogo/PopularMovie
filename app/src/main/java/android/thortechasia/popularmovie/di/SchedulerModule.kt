package android.thortechasia.popularmovie.di

import android.thortechasia.popularmovie.utils.AppDispatcherProvider
import android.thortechasia.popularmovie.utils.DispatcherProvider
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module.module

val schedulerModule = module {

    factory { CompositeDisposable() }
    single<DispatcherProvider> { AppDispatcherProvider() }
}