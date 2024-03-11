package io.h3llo.eco_eats.presentation.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.h3llo.eco_eats.domain.model.Dish

@Composable
fun DishDetailScreen(dish: Dish) {

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = dish.name )

    }
    
}

