package io.h3llo.eco_eats.presentation.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.h3llo.eco_eats.R
import io.h3llo.eco_eats.domain.model.Dish
import io.h3llo.eco_eats.ui.theme.ColorGeneral


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



@Composable
fun DishItem(
    modifier: Modifier = Modifier,
    dish: Dish
) {
    Card(
        border = BorderStroke(
            width = 2.dp,
            color = ColorGeneral
        ), modifier = Modifier
            .fillMaxWidth()
            .clickable {

            }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)

        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(dish.image)
                    .crossfade(2000)
                    .build(),
                contentDescription = dish.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentScale = ContentScale.Crop
            )
            SpacerComponent(modifier = Modifier.height(12.dp))
            TextComponent(
                text = dish.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            SpacerComponent(modifier = Modifier.height(8.dp))
            TextComponent(
                text = "Carbohidratos",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            SpacerComponent(modifier = Modifier.height(2.dp))
            TextComponent(
                text = dish.carbohydrates.toString(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = ColorGeneral
                )
            )

            SpacerComponent(modifier = Modifier.height(2.dp))
            TextComponent(
                text = "Precio",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            SpacerComponent(modifier = Modifier.height(2.dp))
            TextComponent(
                text = "$ ${dish.price}",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = ColorGeneral
                )
            )
            SpacerComponent(modifier = Modifier.height(2.dp))
            RatingBar(currentRating = dish.rating.toInt())

        }

    }
}


@Composable
fun RatingBar(
    maxRating: Int = 5,
    currentRating: Int,
    starsColor: Color = Color.Yellow
) {
    Row {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i < currentRating) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = "Stars",
                tint = if (i <= currentRating) starsColor
                else Color.Unspecified,
                modifier = Modifier
                    .padding(2.dp)
            )
        }
    }
}