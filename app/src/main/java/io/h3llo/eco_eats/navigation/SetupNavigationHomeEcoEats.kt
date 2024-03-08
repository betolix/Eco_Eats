package io.h3llo.eco_eats.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.h3llo.eco_eats.presentation.dish.DishScreen
import io.h3llo.eco_eats.presentation.search.SearchScreen
import io.h3llo.eco_eats.presentation.settings.SettingScreen

@Composable
fun SetupNavigationHomeEcoEats(navHostController: NavHostController, paddingValues: PaddingValues) {

    NavHost(
        navController = navHostController,
        startDestination = HomeScreen.Dish.route
    ) {

        composable(route = HomeScreen.Dish.route){
            DishScreen(paddingValues = paddingValues)
        }
        composable(route = HomeScreen.Search.route){
            SearchScreen()
        }
        composable(route = HomeScreen.Setting.route){
            SettingScreen()
        }
    }
    
}