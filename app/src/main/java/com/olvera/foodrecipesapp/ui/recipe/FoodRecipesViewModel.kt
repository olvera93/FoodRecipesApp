package com.olvera.foodrecipesapp.ui.recipe

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olvera.foodrecipesapp.data.RecipeTasks
import com.olvera.foodrecipesapp.model.FoodRecipe
import com.olvera.foodrecipesapp.model.Result
import com.olvera.foodrecipesapp.util.Constants.Companion.API_KEY
import com.olvera.foodrecipesapp.util.Constants.Companion.DEFAULT_RECIPES_NUMBER
import com.olvera.foodrecipesapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodRecipesViewModel @Inject constructor(
    private val recipeRepository: RecipeTasks
) : ViewModel() {


    var recipesResponse = mutableStateOf<List<Result>>(listOf())
        private set

    var status = mutableStateOf<NetworkResult<Any>?>(null)
        private set

    init {
        getRecipes()
    }

    private fun getRecipes() {
        viewModelScope.launch {
            status.value = NetworkResult.Loading()
            handleNetworkResponse(
                recipeRepository.getRecipes(
                    DEFAULT_RECIPES_NUMBER,
                    API_KEY,
                    "main course",
                    "vegetarian",
                    "true",
                    "true"
                )
            )
        }
    }

    private fun handleNetworkResponse(networkResult: NetworkResult<FoodRecipe>) {
        when (networkResult) {
            is NetworkResult.Success -> {
                recipesResponse.value = networkResult.data!!.results
            }
            is NetworkResult.Error -> {
                status.value = NetworkResult.Error(networkResult.message)
            }
            is NetworkResult.Loading -> {
                status.value = NetworkResult.Loading()
            }
        }
    }


    fun resetApiResponseStatus() {
        status.value = null
    }

}