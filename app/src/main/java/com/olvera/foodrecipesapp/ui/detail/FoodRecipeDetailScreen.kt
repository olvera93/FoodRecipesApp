package com.olvera.foodrecipesapp.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.olvera.foodrecipesapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olvera.foodrecipesapp.composables.Icons
import com.olvera.foodrecipesapp.composables.IconsDetail


@Composable
@Preview
fun FoodRecipeDetailScreen() {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        RecipeInformation()
    }


}


@Composable
fun RecipeInformation() {

    Column {
        RecipeImage()
        RecipeDetail()
    }


}

@Composable
fun RecipeImage() {
    Box(modifier = Modifier.padding(16.dp)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
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
                    iconColor = Color.Red,
                    iconDescription = "Icono",
                    textColor = Color.Black
                )

                Icons(
                    iconId = R.drawable.ic_access_time_24,
                    iconColor = Color.Red,
                    iconDescription = "Time",
                    textColor = Color.Black
                )
            }
        }
    }
}

@Composable
fun RecipeDetail() {
    val myFontFamily = FontFamily(Font(R.font.courgette))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = "Recipe",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = myFontFamily,
            fontSize = 30.sp
        )

        Column {

            Box(
                modifier = Modifier
                    .padding(top = 60.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconsRow()
                    IconsRow()
                }


            }
            Box(modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "osidfdosimvdiomviosdmvaoidmvidvdfsvdfsv")

            }
        }


    }
}


@Composable
fun IconsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconsDetail(
            iconId = R.drawable.ic_check_circle_24,
            iconColor = R.color.green,
            iconDescription = "ICON",
            textColor = R.color.green
        )

        IconsDetail(
            iconId = R.drawable.ic_check_circle_24,
            iconColor = R.color.green,
            iconDescription = "ICON",
            textColor = R.color.green
        )

        IconsDetail(
            iconId = R.drawable.ic_check_circle_24,
            iconColor = R.color.green,
            iconDescription = "ICON",
            textColor = R.color.green
        )
    }
}
