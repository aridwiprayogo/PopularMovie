package com.aridwiprayogo.popularmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

typealias ViewModelClassViewModelProviderMap = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
typealias ViewModelClassViewModelProviderEntry = Map.Entry<Class<out ViewModel>, Provider<ViewModel>>

@Singleton
class ViewModelProviderFactory @Inject constructor(
    @JvmSuppressWildcards private val creators: ViewModelClassViewModelProviderMap
)
    : ViewModelProvider.Factory{
    @Throws(exceptionClasses = [Throwable::class])
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator =
            creators[modelClass] ?:
            creators.entries.firstOrNull { entry: ViewModelClassViewModelProviderEntry ->
                modelClass.isAssignableFrom(entry.key)
            }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
