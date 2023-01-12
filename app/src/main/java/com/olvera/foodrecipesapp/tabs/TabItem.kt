package com.olvera.foodrecipesapp.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import com.olvera.foodrecipesapp.ui.detail.FoodRecipeDetailScreen
import com.olvera.foodrecipesapp.ui.detail.FoodRecipeIngredients
import com.olvera.foodrecipesapp.ui.detail.FoodRecipeInstructions

typealias MyFunction = @Composable () -> Unit
sealed class TabItem(
    var title: String,
    var screen: MyFunction
) {
    @ExperimentalCoilApi
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    object ItemOverview: TabItem("Overview", { FoodRecipeDetailScreen() })

    object ItemIngredients: TabItem("Ingredients", { FoodRecipeIngredients() })

    object ItemInstructions: TabItem("Instructions", { FoodRecipeInstructions() })
}
