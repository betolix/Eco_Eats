package io.h3llo.eco_eats.presentation.welcome

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.h3llo.eco_eats.R
import io.h3llo.eco_eats.presentation.components.ButtonComponent
import io.h3llo.eco_eats.presentation.components.ImageComponent
import io.h3llo.eco_eats.presentation.components.SpacerComponent
import io.h3llo.eco_eats.presentation.components.TextComponent
import io.h3llo.eco_eats.ui.theme.Eco_EatsTheme

@Composable
fun WelcomeScreen(
    onClick:()->Unit

) {
    Column(modifier = Modifier
        .fillMaxSize()
        //.background(Color.White)
        .background(MaterialTheme.colorScheme.surface)

    ) {

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
            .background(MaterialTheme.colorScheme.surface),
            //.background(Color.Gray),
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
                //color = Color.Black,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Preview (name = "Light",showSystemUi = true)
@Preview (name = "Dark", showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreview() {
    Eco_EatsTheme(dynamicColor = false) {
        WelcomeScreen(onClick = {})
    }

}