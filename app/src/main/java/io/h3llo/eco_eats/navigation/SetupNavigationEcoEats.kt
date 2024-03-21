package io.h3llo.eco_eats.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.h3llo.eco_eats.presentation.login.LoginScreen
import io.h3llo.eco_eats.presentation.home.HomeScreen
import io.h3llo.eco_eats.presentation.on_boarding.OnBoardingScreen
import io.h3llo.eco_eats.presentation.welcome.WelcomeScreen

@Composable
fun SetupNavigationEcoEats(){

    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
        //startDestination = Screen.Login.route
    ){
        composable(route = Screen.Welcome.route ){
            WelcomeScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.OnBoarding.route)
                }
            )
        }
        composable(route = Screen.OnBoarding.route){
            OnBoardingScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.Login.route)
                }
            )
        }
        composable(route = Screen.Login.route) {
            LoginScreen(
                onNavigateHome = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }
        composable(route = Screen.Home.route){
            HomeScreen()
        }
    }

}