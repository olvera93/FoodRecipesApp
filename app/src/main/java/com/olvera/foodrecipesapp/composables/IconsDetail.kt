package com.olvera.foodrecipesapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun IconsDetail(
    iconId: Int,
    iconColor: Color,
    iconDescription: String,
    textColor: Color
) {

    Row(modifier = Modifier.padding(end = 16.dp, bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(iconId),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = iconColor),
            alignment = Alignment.Center
        )

        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = iconDescription,
            textAlign = TextAlign.Center,
            color = textColor
        )
    }
}