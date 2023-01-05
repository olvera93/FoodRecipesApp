package com.olvera.foodrecipesapp.data

import com.olvera.foodrecipesapp.data.remote.FoodRecipeApi
import com.olvera.foodrecipesapp.di.DispatchersModule
import com.olvera.foodrecipesapp.model.FoodRecipe
import com.olvera.foodrecipesapp.util.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import com.olvera.foodrecipesapp.util.makeNetworkCall
import kotlinx.coroutines.withContext


interface RecipeTasks {

    // Get Recipes
    suspend fun getRecipes(
        number: String,
        apiKey: String,
        type: String,
        diet: String,
        addRecipeInformation: String,
        fillIngredients: String
    ): NetworkResult<FoodRecipe>

}

class RecipeRepository @Inject constructor(
    private val recipeApi: FoodRecipeApi,
    @DispatchersModule.IoDispatcher private val dispatcher: CoroutineDispatcher
) : RecipeTasks {

    override suspend fun getRecipes(
        number: String,
        apiKey: String,
        type: String,
        diet: String,
        addRecipeInformation: String,
        fillIngredients: String
    ): NetworkResult<FoodRecipe> {
        return withContext(dispatcher) {
            downloadRecipes(number, apiKey, type, diet, addRecipeInformation, fillIngredients)
        }
    }

    private suspend fun downloadRecipes(
        number: String,
        apiKey: String,
        type: String,
        diet: String,
        addRecipeInformation: String,
        fillIngredients: String
    ): NetworkResult<FoodRecipe> =
        makeNetworkCall {
            // Get Recipes
            recipeApi.getRecipes(number, apiKey, type, diet, addRecipeInformation, fillIngredients)
        }
}