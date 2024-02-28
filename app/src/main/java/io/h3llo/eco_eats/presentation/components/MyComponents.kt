package io.h3llo.eco_eats.presentation.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import io.h3llo.eco_eats.R



@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    description: String
    ) {
    Image(
        painter = painterResource(id = image),
        contentDescription = description,
        modifier = modifier
    )
}

@Composable
fun SpacerComponent(
    modifier: Modifier = Modifier
){
    Spacer(modifier = modifier)
}

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    text:String,
    style: TextStyle
){
    Text(
        modifier = modifier,
        text = text,
        style = style
    )
}

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    icon: ImageVector? = null,
    descriptionIcon: String = "",
    containerColor:Color = Color.Blue,
    contentColor:Color = Color.White,
    onClick:()->Unit
    ){
    Button(
        onClick = {
            onClick()
                  },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        if(icon != null){
            Icon(
                imageVector = icon,
                contentDescription = descriptionIcon
            )
        }
        Text(
            text = text,
            style = style
        )
    }
}

@Composable
fun OutlinedTextFieldComponent(
    modifier: Modifier = Modifier,
    text:String,
    textLabel:String,
    colors: TextFieldColors,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    keyboardAction: KeyboardActions,
    trailingIcon : @Composable (()->Unit)? =null,
    onValueChange:(String)->Unit
) {
    OutlinedTextField(
        modifier = Modifier,
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(
                text = textLabel,
                color = Color.Black
                )
        },
        shape = RoundedCornerShape(24.dp),
        colors = colors,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = keyboardAction,
        trailingIcon = trailingIcon
    )
}