package com.olvera.foodrecipesapp.ui.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olvera.foodrecipesapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.olvera.foodrecipesapp.composables.BackNavigationIcon
import com.olvera.foodrecipesapp.composables.Icons
import com.olvera.foodrecipesapp.composables.IconsDetail
import com.olvera.foodrecipesapp.model.Result
import com.olvera.foodrecipesapp.util.Constants


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun FoodRecipeDetailScreen(
    detailViewModel: FoodRecipeDetailViewModel = hiltViewModel()
) {

    val recipe = detailViewModel.recipe.value!!

    Scaffold(topBar = {

    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),

            ) {
            RecipeInformation(recipe)
        }
    }


}


@Composable
fun RecipeInformation(recipe: Result) {

    Column {
        RecipeImage(recipe)
        RecipeDetail(recipe)
    }


}

@Composable
fun RecipeImage(recipe: Result) {
    Box(modifier = Modifier.padding(16.dp)) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(recipe.image)
                .crossfade(true)
                .build(),
            contentDescription = recipe.title,
            alignment = Alignment.Center

        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.BottomEnd
        ) {

            Row(
                modifier = Modifier.padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icons(
                    iconId = R.drawable.ic_favorite_24,
                    iconColor = Color.White,
                    iconDescription = recipe.aggregateLikes.toString(),
                    textColor = Color.White
                )

                Icons(
                    iconId = R.drawable.ic_access_time_24,
                    iconColor = Color.White,
                    iconDescription = recipe.readyInMinutes.toString(),
                    textColor = Color.White
                )
            }
        }
    }
}

@Composable
fun RecipeDetail(recipe: Result) {
    val myFontFamily = FontFamily(Font(R.font.courgette))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = recipe.title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = myFontFamily,
            fontSize = 20.sp
        )

        Column {

            Box(
                modifier = Modifier
                    .padding(top = 65.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconsDetail(
                            iconId = R.drawable.ic_check_circle_24,
                            iconColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            ),
                            iconDescription = stringResource(id = R.string.vegetarian),
                            textColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            )
                        )

                        IconsDetail(
                            iconId = R.drawable.ic_check_circle_24,
                            iconColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            ),
                            iconDescription = stringResource(id = R.string.gluten_free),
                            textColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            )
                        )

                        IconsDetail(
                            iconId = R.drawable.ic_check_circle_24,
                            iconColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            ),
                            iconDescription = stringResource(id = R.string.healthy),
                            textColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            )
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconsDetail(
                            iconId = R.drawable.ic_check_circle_24,
                            iconColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            ),
                            iconDescription = stringResource(id = R.string.vegan),
                            textColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            )
                        )

                        IconsDetail(
                            iconId = R.drawable.ic_check_circle_24,
                            iconColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            ),
                            iconDescription = stringResource(id = R.string.dairy_free),
                            textColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            )
                        )

                        IconsDetail(
                            iconId = R.drawable.ic_check_circle_24,
                            iconColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            ),
                            iconDescription = stringResource(id = R.string.cheap),
                            textColor = if (recipe.vegan) colorResource(id = R.color.green) else colorResource(
                                id = R.color.darkGray
                            )
                        )


                    }
                }


            }
            Box(modifier = Modifier.padding(top = 16.dp)) {
                Text(text = Constants.parseHtml(recipe.summary))

            }
        }
    }
}


