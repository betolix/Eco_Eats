package io.h3llo.eco_eats.presentation.dish

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.h3llo.eco_eats.domain.model.Dish
import io.h3llo.eco_eats.presentation.components.SpacerComponent
import io.h3llo.eco_eats.presentation.components.TextComponent
import io.h3llo.eco_eats.ui.theme.ColorGeneral


@Composable
fun DishScreen(
    paddingValues: PaddingValues,
    viewModel: DishViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.TopCenter
    ) {

        LaunchedEffect(key1 = true) {
            viewModel.getDishes()
        }

        //Text(text = "Alohaaaaaaa")
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            state.dishes?.let { dishes ->
                items(dishes) {
                    // Text(text = it.name)
                    DishItem(dish = it)


                }
            }
        }

    }
}

@Composable
fun DishItem(
    modifier: Modifier = Modifier,
    dish: Dish
) {
    Card(
        border = BorderStroke(
            width = 2.dp,
            color = ColorGeneral
        ), modifier = Modifier
            .fillMaxWidth()
            .clickable {

            }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)

        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(dish.image)
                    .crossfade(2000)
                    .build(),
                contentDescription = dish.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentScale = ContentScale.Crop
            )
            SpacerComponent(modifier = Modifier.height(12.dp))
            TextComponent(
                text = dish.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            SpacerComponent(modifier = Modifier.height(8.dp))
            TextComponent(
                text = "Carbohidratos",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            SpacerComponent(modifier = Modifier.height(2.dp))
            TextComponent(
                text = dish.carbohydrates.toString(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = ColorGeneral
                )
            )

            SpacerComponent(modifier = Modifier.height(2.dp))
            TextComponent(
                text = "Precio",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            SpacerComponent(modifier = Modifier.height(2.dp))
            TextComponent(
                text = "$ ${dish.price}",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = ColorGeneral
                )
            )
            SpacerComponent(modifier = Modifier.height(2.dp))
            RatingBar(currenRating = dish.rating.toInt())

        }

    }
}


@Composable
fun RatingBar(
    maxRating: Int = 5,
    currenRating: Int,
    starsColor: Color = Color.Yellow
) {
    Row {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i < currenRating) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = "Stars",
                tint = if (i <= currenRating) starsColor
                else Color.Unspecified,
                modifier = Modifier
                    .padding(2.dp)
            )
        }
    }
}