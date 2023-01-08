package com.olvera.foodrecipesapp.ui.foodjoke

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olvera.foodrecipesapp.data.RecipeTasks
import com.olvera.foodrecipesapp.model.FoodJoke
import com.olvera.foodrecipesapp.util.Constants
import com.olvera.foodrecipesapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodJokeViewModel @Inject constructor(
    private val repository: RecipeTasks
) : ViewModel() {

    var foodJoke = mutableStateOf<String>("")
    var status = mutableStateOf<NetworkResult<Any>?>(null)
        private set

    init {
        getFoodJoke()
    }

    private fun getFoodJoke() = viewModelScope.launch {
        status.value = NetworkResult.Loading()
        handleNetworkResponse(repository.getFoodJoke(Constants.API_KEY))
    }

    private fun handleNetworkResponse(networkResult: NetworkResult<FoodJoke>) {
        when (networkResult) {
            is NetworkResult.Success -> {
                foodJoke.value = networkResult.data!!.text
            }
            is NetworkResult.Error -> {
                status.value = NetworkResult.Error(networkResult.message)
            }
            is NetworkResult.Loading -> {
                status.value = NetworkResult.Loading()
            }
        }
    }


}