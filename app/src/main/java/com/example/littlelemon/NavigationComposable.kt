package com.example.littlelemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = Destinations.Home.route) {
        composable(Destinations.Home.route) {
            Home()
        }
        composable(Destinations.Profile.route) {
            Profile()
        }
    }
}