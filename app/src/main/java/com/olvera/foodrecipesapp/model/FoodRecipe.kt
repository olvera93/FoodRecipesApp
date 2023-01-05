package com.olvera.foodrecipesapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodRecipe(
    @SerializedName("results")
    val results: List<Result>
): Parcelable
