package com.olvera.foodrecipesapp.util

import org.jsoup.Jsoup

class Constants {
    companion object {
        const val API_KEY = "YOUR_API"
        const val BASE_URL = "https://api.spoonacular.com/"
        const val BASE_IMAGE_URL_INGREDIENTS = "https://spoonacular.com/cdn/ingredients_100x100/"
        const val BASE_IMAGE_URL = "https://spoonacular.com/recipeImages/"
        // API Query Keys
        const val QUERY_SEARCH = "query"
        const val QUERY_NUMBER = "number"
        const val QUERY_API_KEY = "apiKey"
        const val QUERY_TYPE = "type"
        const val QUERY_DIET = "diet"
        const val QUERY_ADD_RECIPE_INFORMATION = "addRecipeInformation"
        const val QUERY_FILL_INGREDIENTS = "fillIngredients"

        // Bottom Sheet and Preferences
        const val DEFAULT_RECIPES_NUMBER = "25"
        const val DEFAULT_MEAL_TYPE = "main course"
        const val DEFAULT_DIET_TYPE = "gluten free"

        const val PREFERENCES_NAME = "foody_preferences"
        const val PREFERENCES_MEAL_TYPE = "mealType"
        const val PREFERENCES_MEAL_TYPE_ID = "mealTypeId"
        const val PREFERENCES_DIET_TYPE = "dietType"
        const val PREFERENCES_DIET_TYPE_ID = "dietTypeId"
        const val PREFERENCES_BACK_ONLINE = "backOnline"

        fun parseHtml(description: String): String {
            return Jsoup.parse(description).text()
        }

    }


}