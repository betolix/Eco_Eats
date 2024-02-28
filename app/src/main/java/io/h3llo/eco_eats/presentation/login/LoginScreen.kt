package io.h3llo.eco_eats.presentation.login


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import io.h3llo.eco_eats.presentation.components.ImageComponent
import io.h3llo.eco_eats.R
import io.h3llo.eco_eats.presentation.components.ButtonComponent
import io.h3llo.eco_eats.presentation.components.OutlinedTextFieldComponent
import io.h3llo.eco_eats.ui.theme.ColorGeneral


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {

    val state = viewModel.state

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
            LoginContent(viewModel, state)

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
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
fun LoginContent(viewModel: LoginViewModel, state: LoginState) {

    val focusManager = LocalFocusManager.current

    var email by remember {
        mutableStateOf("jledesma2509@gmail.com")
    }

    var password by remember {
        mutableStateOf("123")
    }

    var visualTransformation by remember {
        mutableStateOf(false)
    }

    Text(
        text = "Login",
        style = TextStyle(
            color = ColorGeneral,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    )

    OutlinedTextFieldComponent(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        text = email,
        textLabel = "Ingrese su correo",
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = ColorGeneral,
            unfocusedBorderColor = Color.LightGray,
        ),
        keyboardType = KeyboardType.Email,
        imeAction = ImeAction.Next,
        keyboardAction = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        ),
        onValueChange = {
             email = it
        }
    )

    OutlinedTextFieldComponent(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        text = password,
        textLabel = "Ingrese su contraseña",
        visualTransformation = if (visualTransformation)PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = ColorGeneral,
            unfocusedBorderColor = Color.LightGray,
        ),
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Done,
        keyboardAction = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        onValueChange = {
            password = it
        },
        trailingIcon = {
            IconButton(onClick = { visualTransformation = !visualTransformation }) {
                Icon(
                    imageVector = if(visualTransformation)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff,
                    contentDescription = "Visibility"
                )
            }

        }
    )

    if(state.isLoading){
        androidx.compose.material3.CircularProgressIndicator()
    }

    if(state.successful != null ){
        Text(text = "${state.successful?.email}")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ){
        ButtonComponent(
            modifier = Modifier
                .fillMaxWidth(),
                //.height(52.dp),
            text = "Ingresar",
            style = TextStyle(
                fontSize = 16.sp
            ),
            onClick = {
                      viewModel.signIn( email, password)
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





//    OutlinedTextField(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 8.dp),
//
//        value = "",
//        onValueChange = {  },
//        label = {
//            Text(
//                text = "Correo",
//                fontSize = 16.sp
//            )
//        },
//        placeholder = {
//            Text(
//                text = "Ingrese su correo",
//                fontSize = 16.sp
//            )
//        },
//        shape = RoundedCornerShape(24.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = ColorGeneral,
//            unfocusedBorderColor = Color.LightGray,
//        )
//    )

//    OutlinedTextField(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 8.dp),
//        value = "",
//        onValueChange = {  },
//        label = {
//            Text(
//                text = "Contraseña",
//                fontSize = 16.sp
//            )
//        },
//        placeholder = {
//            Text(
//                text = "Ingrese su contraseña",
//                fontSize = 16.sp
//            )
//        },
//        shape = RoundedCornerShape(24.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = ColorGeneral,
//            unfocusedBorderColor = Color.LightGray,
//        )
//    )