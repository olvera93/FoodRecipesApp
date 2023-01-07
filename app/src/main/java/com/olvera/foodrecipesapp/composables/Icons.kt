package com.olvera.foodrecipesapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Icons(
    iconId: Int,
    iconColor: Color,
    iconDescription: String,
    textColor: Color
) {

    Column(modifier = Modifier.padding(end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(4.dp),
            painter = painterResource(id = iconId),
            contentDescription = "",
            colorFilter = ColorFilter.tint(iconColor),
            alignment = Alignment.Center
        )

        Text(
            text = iconDescription, textAlign = TextAlign.Center,
            color = textColor
        )
    }


}