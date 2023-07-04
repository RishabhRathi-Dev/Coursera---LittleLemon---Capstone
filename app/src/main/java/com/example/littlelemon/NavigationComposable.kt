package com.example.littlelemon

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Navigation(context: Context, navController: NavHostController) {
    val sharedPreferences = context.getSharedPreferences("onboarded", Context.MODE_PRIVATE)
    val onboarded = sharedPreferences.getBoolean("onboarded", false)
    var startDestination = Onboarding.route

    if (onboarded) {
        startDestination = Home.route
    }

    NavHost(navController = navController, startDestination = startDestination){
        composable(Onboarding.route){
            Onboarding(context, navController)
        }
        composable(Home.route){
            Home(navController)
        }
        composable(Profile.route){
            Profile(context, navController)
        }
    }
}