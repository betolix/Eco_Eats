package io.h3llo.eco_eats.presentation.dish

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun DishScreen() {

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Dishes")
        }
}