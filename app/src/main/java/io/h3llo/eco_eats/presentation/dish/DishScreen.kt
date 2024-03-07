package io.h3llo.eco_eats.presentation.dish

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun DishScreen(
    viewModel: DishViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        LaunchedEffect(key1 = true) {
            viewModel.getDishes()
        }

        //Text(text = "Alohaaaaaaa")
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ){
            state.dishes?.let {dishes->
                items(dishes){
                    Text(text = it.name)
                   // Text(text = "Alohaaaaaaa")
                }
            }
        }

    }
}