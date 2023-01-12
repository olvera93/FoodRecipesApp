package com.olvera.foodrecipesapp.ui.detail

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun FoodRecipeInstructions(
    detailViewModel: FoodRecipeDetailViewModel = hiltViewModel()
) {
    val recipe = detailViewModel.recipe.value!!
    val instructions = recipe.sourceUrl

    Box(modifier = Modifier.fillMaxSize()) {
        WebViewFood(url = instructions)
    }

}

@Composable
fun WebViewFood(
    url: String
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        }
    )
}
