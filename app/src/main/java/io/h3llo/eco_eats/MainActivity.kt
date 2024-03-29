package io.h3llo.eco_eats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import io.h3llo.eco_eats.data.networking.Api
import io.h3llo.eco_eats.navigation.SetupNavigationEcoEats
import io.h3llo.eco_eats.ui.theme.Eco_EatsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Api.build()

        setContent {
            Eco_EatsTheme(dynamicColor = false) {
                SetupNavigationEcoEats()
            }

        }
    }
}
