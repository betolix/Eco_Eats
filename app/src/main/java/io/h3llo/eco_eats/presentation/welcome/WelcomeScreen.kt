package io.h3llo.eco_eats.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.h3llo.eco_eats.R
import io.h3llo.eco_eats.navigation.Screen
import io.h3llo.eco_eats.presentation.components.ButtonComponent
import io.h3llo.eco_eats.presentation.components.ImageComponent
import io.h3llo.eco_eats.presentation.components.SpacerComponent
import io.h3llo.eco_eats.presentation.components.TextComponent

@Composable
fun WelcomeScreen(
    onClick:()->Unit

) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            //.background(Color.Green),
            contentAlignment = Alignment.Center

        ){
            WelcomeHeader()

        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Gray),
            contentAlignment = Alignment.BottomCenter
            ){
            WelcomeContent(
                onClick = {
                    onClick()
                }
            )


        }

    }
}

@Composable
fun WelcomeContent(
    onClick:()->Unit
) {


    ImageComponent(
        modifier = Modifier.fillMaxSize(),
        image = R.drawable.background_fruits,
        description = "Background Fruits"
    )
    ButtonComponent(
        modifier = Modifier.padding(bottom = 48.dp),
        text = "Empezar",
        style = TextStyle(
            fontWeight = FontWeight.Bold
        ),
        onClick = {
                onClick()
        }
    )

}

@Composable
fun WelcomeHeader() {
    Column {
        ImageComponent(
            image = R.drawable.ecoeats_logo,
            description = "Ecoeats Logo",
            modifier = Modifier
                .fillMaxWidth()
                .size(25.dp))
        SpacerComponent(modifier = Modifier.height(8.dp))

        TextComponent(
            modifier = Modifier.fillMaxWidth(),
            text = "Una vida saludable",
            style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Preview (showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onClick = {})
}