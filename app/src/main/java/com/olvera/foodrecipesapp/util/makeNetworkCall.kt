package com.olvera.foodrecipesapp.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call: suspend () -> T
): NetworkResult<T> {

    return withContext(Dispatchers.IO) {

        try {

            NetworkResult.Success(
                call()
            )
        } catch (e: UnknownHostException) {
            NetworkResult.Error("Error desconocido")
        } catch (e: Exception) {

            val errorMessage = when (e.message) {
                "sign_up_error" -> "R.string.error_sign_up"
                "sign_in_error" -> "R.string.error_sign_in"
                "user_already_exists" -> "R.string.user_already_exists"
                "error_adding_dog" -> "R.string.error_adding_dog"
                else ->"Error desconocido"
            }

            NetworkResult.Error(errorMessage)
        }
    }

}