package android.thortechasia.popularmovie.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
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
        viewModelScope.cancel()
    }
}
