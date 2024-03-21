@file:OptIn(ExperimentalPagerApi::class)

package io.h3llo.eco_eats.presentation.on_boarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import io.h3llo.eco_eats.presentation.components.ImageComponent
import io.h3llo.eco_eats.presentation.components.TextComponent
import io.h3llo.eco_eats.ui.theme.EXTRA_LARGE_PADDING
import io.h3llo.eco_eats.ui.theme.SMALL_PADDING


@Composable
fun OnBoardingScreen(
    onClick: () -> Unit
) {

    val pagerState = rememberPagerState()

    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background( MaterialTheme.colorScheme.surface )
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { page ->
            OnBoardingContent(pages[page])
            
        }

        Row(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            OnBoardingFooter(pages, pagerState)
        }

        FinishButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            pagerState = pagerState,
            pages = pages,
            onClick = {
                onClick()
            })

    }
}



@Composable
fun OnBoardingContent(onBoardingPage: OnBoardingPage) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ImageComponent(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            image = onBoardingPage.image,
            description = onBoardingPage.description
        )
        TextComponent(
            text = onBoardingPage.title,
            style =  TextStyle(
                //color = Color.Black,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        TextComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            style =  TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                //color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        )
    }


}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingFooter(pages: List<OnBoardingPage>, pagerState: PagerState) {
    repeat(pages.size){iteration ->
        val color = if(pagerState.currentPage == iteration ) MaterialTheme.colorScheme.primary else Color.Gray
        Box(modifier = Modifier
            .padding(2.dp)
            .clip(CircleShape)
            .background(color)
            .size(12.dp)
        )
    }
    
}

@Composable
fun FinishButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pages: List<OnBoardingPage>,
    onClick:()->Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ){
        AnimatedVisibility(

            visible = pagerState.currentPage == pages.size-1
        ) {
            Button(onClick = { onClick() }) {
                TextComponent(
                    text = "Finish",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
            
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(onClick = {})
}