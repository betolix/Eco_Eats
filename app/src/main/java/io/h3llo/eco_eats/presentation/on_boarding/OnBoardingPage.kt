package io.h3llo.eco_eats.presentation.on_boarding

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import io.h3llo.eco_eats.R

sealed class OnBoardingPage (
    @DrawableRes
    val image:Int,
    val title: String,
    val description: String
){
    object First : OnBoardingPage(
        image = R.drawable.on_boarding_image_1,
        title = "Greetings",
        description = "Are you a Boruto fan? Because if you are then we have a great news for you!"
    )

    object Second : OnBoardingPage(
        image = R.drawable.on_boarding_image_2,
        title = "Explore",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
    )

    object Third : OnBoardingPage(
        image = R.drawable.on_boarding_image_3,
        title = "Power",
        description = "Are you a Boruto fan? Because if you are then we have a great news for you!"
    )
}