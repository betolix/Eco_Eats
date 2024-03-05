package io.h3llo.eco_eats.navigation

sealed class HomeScreen (val route:String) {

    object Dish: Screen(route ="dish_screen")
    object Search: Screen(route ="search_screen")
    object Setting: Screen(route ="setting_screen")

}