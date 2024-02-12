package io.h3llo.eco_eats.presentation.welcome

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeScreen(
    onNavigation:()->Unit
) {
    Button(onClick = {
        onNavigation()
        }) {
        Text(text = "Navegar")

        
    }
}

@Preview (showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onNavigation = {})
}