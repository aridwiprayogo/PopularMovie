package android.thortechasia.popularmovie.ui.movie

import android.thortechasia.popularmovie.utils.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi

@UseExperimental(ExperimentalCoroutinesApi::class)
class TestDispatcherProvider:DispatcherProvider {
    override fun ui(): CoroutineDispatcher = Dispatchers.Unconfined
    override fun io(): CoroutineDispatcher = Dispatchers.Unconfined
    override fun computation(): CoroutineDispatcher= Dispatchers.Unconfined
}