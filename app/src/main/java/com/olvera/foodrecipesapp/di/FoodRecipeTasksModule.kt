package com.olvera.foodrecipesapp.di

import com.olvera.foodrecipesapp.data.RecipeRepository
import com.olvera.foodrecipesapp.data.RecipeTasks
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FoodRecipeTasksModule {

    @Binds
    abstract fun bindFoodRecipeTasks(
        foodRecipeRepository: RecipeRepository
    ): RecipeTasks


}