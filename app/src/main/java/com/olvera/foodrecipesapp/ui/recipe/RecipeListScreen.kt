package com.olvera.foodrecipesapp.ui.recipe

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import com.olvera.foodrecipesapp.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.olvera.foodrecipesapp.composables.Icons
import com.olvera.foodrecipesapp.model.Result

private const val GRID_SPAN_COUNT = 1

@Composable
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
fun RecipeListScreen(
    viewModel: FoodRecipesViewModel = hiltViewModel()
) {

    val recipe = viewModel.recipesResponse.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 32.dp)
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(GRID_SPAN_COUNT),
            content = {
                items(recipe) { recipe ->
                    RecipeGridItem(recipe = recipe)
                }
            }
        )
    }
}


@Composable
@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
fun RecipeGridItem(recipe: Result) {

    val myFontFamily = FontFamily(Font(R.font.courgette))

    Surface(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 6.dp,
        shape = RoundedCornerShape(4.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            AsyncImage(
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(recipe.image)
                    .crossfade(true)
                    .build(),
                contentDescription = recipe.title
            )



            Column(
                modifier = Modifier.padding(start = 16.dp),
            ) {
                Text(
                    modifier = Modifier.padding(),
                    text = recipe.title,
                    fontSize = 18.sp,
                    fontFamily = myFontFamily
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = recipe.summary,
                    maxLines = 3
                )

                Row(modifier = Modifier.padding(top = 16.dp)) {

                    Icons(
                        iconId = R.drawable.ic_favorite_24,
                        iconColor = Color.Red,
                        iconDescription = recipe.aggregateLikes.toString(),
                        textColor = Color.Red
                    )

                    Icons(
                        iconId = R.drawable.ic_access_time_24,
                        iconColor = colorResource(id = R.color.yellow),
                        iconDescription = recipe.readyInMinutes.toString(),
                        textColor = colorResource(id = R.color.yellow)
                    )

                    Icons(
                        iconId = R.drawable.ic_leaf,
                        iconColor = if (recipe.vegetarian) Color.Green else Color.DarkGray,
                        iconDescription = if (recipe.vegetarian) "Vegan" else "Not Vegan",
                        textColor = if (recipe.vegetarian) Color.Green else Color.DarkGray
                    )

                }
            }
        }
    }
}