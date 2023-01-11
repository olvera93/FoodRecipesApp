package com.olvera.foodrecipesapp.util

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.olvera.foodrecipesapp.model.Result
import com.olvera.foodrecipesapp.ui.detail.FoodRecipeDetailActivity
import com.olvera.foodrecipesapp.ui.foodjoke.FoodJokeScreen
import com.olvera.foodrecipesapp.ui.recipe.RecipeListScreen


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = ItemsMenu.Main.route
    ) {

        composable(ItemsMenu.Main.route) {
            RecipeListScreen(onRecipeClicked = {

                val intent = Intent(navController.context, FoodRecipeDetailActivity::class.java)
                intent.putExtra(FoodRecipeDetailActivity.RECIPE_KEY, it)
                navController.context.startActivity(intent)

            })
        }

        composable(ItemsMenu.FoodRecipeJoke.route) {
            FoodJokeScreen()
        }

    }
}