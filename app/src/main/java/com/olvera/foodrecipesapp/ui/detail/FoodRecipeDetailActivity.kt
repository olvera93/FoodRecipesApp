package com.olvera.foodrecipesapp.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.olvera.foodrecipesapp.tabs.TabPrincipal
import com.olvera.foodrecipesapp.ui.detail.ui.theme.FoodRecipesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@AndroidEntryPoint
class FoodRecipeDetailActivity : ComponentActivity() {

    companion object {
        const val RECIPE_KEY = "recipe"
    }

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //FoodRecipeDetailScreen()
                    TabPrincipal(onNavigationIconClick = ::onNavigationIconClick,)
                }
            }
        }
    }

    private fun onNavigationIconClick() {
        finish()
    }
}

