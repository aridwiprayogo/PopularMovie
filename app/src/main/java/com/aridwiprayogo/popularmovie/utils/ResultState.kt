package com.aridwiprayogo.popularmovie.utils

sealed class ResultState<T> {
    object Loading: ResultState<Nothing>()
    data class Success<T>(val value: T): ResultState<T>()
    data class Failed(val message: String): ResultState<String>()
}