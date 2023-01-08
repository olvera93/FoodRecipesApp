package com.olvera.foodrecipesapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodJoke(
    @SerializedName("text")
    val text: String
) : Parcelable
