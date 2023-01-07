package com.olvera.foodrecipesapp.util

import com.olvera.foodrecipesapp.R

sealed class ItemsMenu(
    val icon: Int,
    val title: String,
    val route: String
) {

    object Main: ItemsMenu(R.drawable.ic_restaurant_24, "Recipe", "home")
    object FoodRecipeJoke: ItemsMenu(R.drawable.ic_food_joke_24, "Recipe Joke", "joke")


}
