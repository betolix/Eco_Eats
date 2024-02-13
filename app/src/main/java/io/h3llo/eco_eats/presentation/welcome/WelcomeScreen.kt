package io.h3llo.eco_eats.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.h3llo.eco_eats.R
import io.h3llo.eco_eats.presentation.components.ImageComponent

@Composable
fun WelcomeScreen(
    onNavigation:()->Unit
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
            .background(Color.Gray)){
            WelcomeContent()


        }

    }
}

@Composable
fun WelcomeContent() {

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
    }
}

@Preview (showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onNavigation = {})
}