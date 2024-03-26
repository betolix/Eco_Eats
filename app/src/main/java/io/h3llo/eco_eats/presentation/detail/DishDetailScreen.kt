package io.h3llo.eco_eats.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.h3llo.eco_eats.domain.model.Dish
import io.h3llo.eco_eats.presentation.login.LoginContent
import io.h3llo.eco_eats.presentation.login.LoginFooter
import io.h3llo.eco_eats.presentation.login.LoginHeader

@Composable
fun DishDetailScreen(dish: Dish) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(top = 65.dp)


    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(dish.image)
                    .crossfade(2000)
                    .build(),
                contentDescription = dish.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp),

            ) {
            Text("Alohaaa")

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            //.background(Color(0, 255, 0, 200))
        ) {
            LoginFooter()

        }
    }
    
}


@Preview(showSystemUi = true)
@Composable
private fun DishDetailScreenPreview() {
    DishDetailScreen(
        dish = Dish(
            id = 7,
            name = "Ceviche",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            thumbails = "http://h3llo.io/eco_eats/eco_eats_ceviche.jpeg",
            image = "http://h3llo.io/eco_eats/eco_eats_ceviche.jpeg",
            carbohydrates = 30.0,
            proteins = 20.0,
            price = 30.0,
            rating = 5.0,
            ingredients = "1 Lenguado| 1 litro de limon | 1 sachet de Caldo en Polvo de Pollo Gourmet",
            flagHeader = true
        )
    )
}

