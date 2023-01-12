package com.olvera.foodrecipesapp.ui.foodjoke

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.olvera.foodrecipesapp.R

@Composable
fun FoodJokeScreen(viewModel: FoodJokeViewModel = hiltViewModel()) {

    val recipe = viewModel.foodJoke.value

    Image(
        painter = painterResource(id = R.drawable.ic_food_joke_background),
        contentDescription = ""
    )

    Box(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(bottom = 16.dp),
        contentAlignment = Alignment.Center) {
        FoodRecipeJokeCard(foodJoke = recipe)
    }



}


@Composable
fun FoodRecipeJokeCard(foodJoke: String) {

    Box(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(15.dp),
            elevation = 10.dp

        ) {

            Text(
                modifier = Modifier.padding(8.dp),
                text = foodJoke,
                fontSize = 20.sp,
                color = Color.Black
                )

        }
    }


}