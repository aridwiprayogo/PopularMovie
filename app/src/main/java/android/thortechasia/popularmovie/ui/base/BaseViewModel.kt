package android.thortechasia.popularmovie.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class BaseViewModel: ViewModel() {

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
