package android.thortechasia.popularmovie.di

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module.module

val scheduledModule = module {
    factory { CompositeDisposable() }
}