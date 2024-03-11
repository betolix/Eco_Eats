package io.h3llo.eco_eats.navigation

sealed class HomeScreen (val route:String) {

    object Dish: HomeScreen(route ="dish_screen")
    object Search: HomeScreen(route ="search_screen")
    object Setting: HomeScreen(route ="setting_screen")

    object Detail: HomeScreen(route = "detail_screen/?dishJson={dishJson}"){

        fun createRoute(dishJson:String) = "detail_screen/?dishJson=$dishJson"

    }

}