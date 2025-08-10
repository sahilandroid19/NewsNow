package com.example.newsnow.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Screens {
    SPLASH_SCREEN, NEWS_SCREEN, NEWS_DETAIL_SCREEN, SETTINGS_SCREEN
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SPLASH_SCREEN.name) {
        composable(Screens.SPLASH_SCREEN.name) {
            SplashScreen(navController)
        }

        composable(Screens.NEWS_SCREEN.name) {
            SplashScreen(navController)
        }

        composable(Screens.NEWS_DETAIL_SCREEN.name) {
            SplashScreen(navController)
        }

        composable(Screens.SETTINGS_SCREEN.name) {
            SplashScreen(navController)
        }
    }
}