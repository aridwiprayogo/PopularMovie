package android.thortechasia.popularmovie.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseViewModel: ViewModel(), CoroutineScope {

    protected val movieJob = ArrayList<Job>()

    override val coroutineContext: CoroutineContext
        get() = Main

    infix fun ArrayList<Job>.add(job: Job){
        this.add(job)
    }

    override fun onCleared() {
        super.onCleared()
        movieJob.forEach { if (!it.isCancelled) it.cancel() }
    }
}
