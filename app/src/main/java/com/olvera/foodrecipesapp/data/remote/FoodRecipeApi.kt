package com.olvera.foodrecipesapp.data.remote

import com.olvera.foodrecipesapp.model.FoodRecipe
import com.olvera.foodrecipesapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodRecipeApi {

    @GET("recipes/complexSearch")
    suspend fun getRecipes(
        @Query(Constants.QUERY_NUMBER) number: String,
        @Query(Constants.QUERY_API_KEY) apiKey: String,
        @Query(Constants.QUERY_TYPE) type: String,
        @Query(Constants.QUERY_DIET) diet: String,
        @Query(Constants.QUERY_ADD_RECIPE_INFORMATION) addRecipeInformation: String,
        @Query(Constants.QUERY_FILL_INGREDIENTS) fillIngredients: String
    ): FoodRecipe
}