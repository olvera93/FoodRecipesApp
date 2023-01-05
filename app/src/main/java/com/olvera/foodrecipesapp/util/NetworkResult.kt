package com.olvera.foodrecipesapp.util

sealed class NetworkResult<T>(
) {

    class Success<T>(val data: T) : NetworkResult<T>()
    class Error<T>(val message: String?) : NetworkResult<T>()
    class Loading<T> : NetworkResult<T>()


}