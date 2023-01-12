package com.olvera.foodrecipesapp.ui.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.olvera.foodrecipesapp.R
import com.olvera.foodrecipesapp.model.ExtendedIngredient
import com.olvera.foodrecipesapp.util.Constants.Companion.BASE_IMAGE_URL_INGREDIENTS

private const val GRID_SPAN_COUNT = 1


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun FoodRecipeIngredients(
    detailViewModel: FoodRecipeDetailViewModel = hiltViewModel()
) {

    val recipe = detailViewModel.recipe.value!!
    val ingredients = recipe.extendedIngredients

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 32.dp)
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(GRID_SPAN_COUNT),
            content = {
                items(ingredients) { ingredients ->
                    IngredientGridItem(ingredient = ingredients)
                }
            }
        )
    }

}

@Composable
fun IngredientGridItem(ingredient: ExtendedIngredient) {

    val myFontFamily = FontFamily(Font(R.font.courgette))

    Surface(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(BASE_IMAGE_URL_INGREDIENTS + ingredient.image)
                    .crossfade(2)
                    .crossfade(true)
                    .build(),
                contentDescription = ingredient.name
            )

            Column {
                Text(
                    text = ingredient.name,
                    fontSize = 20.sp,
                    fontFamily = myFontFamily,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = ingredient.original,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = ingredient.consistency,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}