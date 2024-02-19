package io.h3llo.eco_eats.presentation.login


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.h3llo.eco_eats.presentation.components.ImageComponent
import io.h3llo.eco_eats.R
import io.h3llo.eco_eats.presentation.components.ButtonComponent
import io.h3llo.eco_eats.ui.theme.ColorGeneral


@Composable
fun LoginScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginHeader()

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp),

        ) {
            LoginContent()

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                //.background(Color(0, 255, 0, 200))
        ) {
            LoginFooter()

        }
    }
}

@Composable
fun LoginHeader() {
    ImageComponent(
        modifier = Modifier.size(150.dp),
        image = R.drawable.logo_ecoeats,
        description = "EcoEats Logo"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent() {

    Text(
        text = "Login",
        style = TextStyle(
            color = ColorGeneral,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    )

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),

        value = "",
        onValueChange = {  },
        label = {
            Text(
                text = "Correo",
                fontSize = 16.sp
            )
        },
        placeholder = {
            Text(
                text = "Ingrese su correo",
                fontSize = 16.sp
            )
        },
        shape = RoundedCornerShape(24.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = ColorGeneral,
            unfocusedBorderColor = Color.LightGray,
        )
    )

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),

        value = "",
        onValueChange = {  },
        label = {
            Text(
                text = "Contraseña",
                fontSize = 16.sp
            )
        },
        placeholder = {
            Text(
                text = "Ingrese su correo",
                fontSize = 16.sp
            )
        },
        shape = RoundedCornerShape(24.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = ColorGeneral,
            unfocusedBorderColor = Color.LightGray,
        )
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ){
        ButtonComponent(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            text = "Ingresar",
            style = TextStyle(
                fontSize = 16.sp
            ),
            onClick = {

            },
            containerColor = ColorGeneral,
        )
    }

}

@Composable
fun LoginFooter() {

}



@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}