package com.example.littlelemon

sealed class Destinations(val route: String) {
    object Onboarding : Destinations("onboarding")
    object Home : Destinations("home")
    object Profile : Destinations("profile")
}