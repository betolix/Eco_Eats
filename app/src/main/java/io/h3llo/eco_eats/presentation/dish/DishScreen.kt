package io.h3llo.eco_eats.presentation.dish

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import io.h3llo.eco_eats.domain.model.Dish
import io.h3llo.eco_eats.presentation.components.DishItem
import io.h3llo.eco_eats.presentation.components.PagerDishHeaderComponent
import io.h3llo.eco_eats.presentation.components.SpacerComponent
import io.h3llo.eco_eats.presentation.components.TextComponent
import io.h3llo.eco_eats.ui.theme.ColorGeneral


@OptIn(ExperimentalPagerApi::class)
@Composable
fun DishScreen(
    paddingValues: PaddingValues,
    viewModel: DishViewModel = hiltViewModel(),
    onNavigation:(Dish)->Unit
) {

    val state = viewModel.state
    val pagerState = rememberPagerState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.TopCenter
    ) {

        LaunchedEffect(key1 = true) {
            viewModel.getDishes()
        }

        Column {

            TextComponent(
                text = "¿Qué hay de nuevo?",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 8.dp)
            )

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                state.dishes?.let{ dishes->
                    val dishesFlag = dishes.filter {
                        it.flagHeader
                    }

                    HorizontalPager(
                        count = dishesFlag.size,
                        state = pagerState,
                        verticalAlignment = Alignment.Top
                    ) {position ->
                        PagerDishHeaderComponent(
                            dishesFlag[position],
                            onClick = {
                                onNavigation(it)
                            }
                        )

                    }
                    Row(
                        modifier = Modifier.padding(bottom = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy (8.dp)
                    ) {
                        repeat(dishesFlag.size){iteration ->
                            val color = if(pagerState.currentPage == iteration) Color.White else Color.Gray
                            Box (
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .size(12.dp)
                            )
                        }
                    }

                }
            }

            TextComponent(
                text = "Carta del dia",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 8.dp)
            )
            
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                state.dishes?.let { dishes ->
                    items(dishes) {
                        // Text(text = it.name)
                        DishItem(dish = it){
                            onNavigation(it)
                        }
                    }
                }
            }

        }

    }
}

