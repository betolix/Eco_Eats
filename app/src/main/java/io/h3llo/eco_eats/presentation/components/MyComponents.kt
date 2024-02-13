package io.h3llo.eco_eats.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import io.h3llo.eco_eats.R



@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    description: String
    ) {
    Image(
        painter = painterResource(id = image),
        contentDescription = description,
        modifier = modifier
    )
}

@Composable
fun SpacerComponent(
    modifier: Modifier = Modifier
){
    Spacer(modifier = modifier)
}

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    text:String,
    style: TextStyle
){
    Text(
        modifier = modifier,
        text = text,
        style = style
    )

}