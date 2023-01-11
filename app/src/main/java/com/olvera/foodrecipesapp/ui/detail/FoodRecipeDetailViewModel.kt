package com.olvera.foodrecipesapp.ui.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import coil.annotation.ExperimentalCoilApi
import com.olvera.foodrecipesapp.data.RecipeTasks
import com.olvera.foodrecipesapp.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@HiltViewModel
class FoodRecipeDetailViewModel @Inject constructor(
    private val recipeRepository: RecipeTasks,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var recipe = mutableStateOf(
        savedStateHandle.get<Result>(FoodRecipeDetailActivity.RECIPE_KEY)
    )
        private set



}