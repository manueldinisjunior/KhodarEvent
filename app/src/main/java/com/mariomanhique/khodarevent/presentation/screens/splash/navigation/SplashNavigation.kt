package com.mariomanhique.khodarevent.presentation.screens.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mariomanhique.khodarevent.presentation.screens.splash.SplashScreen

const val splashRoute = "splashRoute"
fun NavGraphBuilder.splashRoute(
    navigateToHome: () -> Unit,
){
    composable(splashRoute){
        SplashScreen {
            navigateToHome()
        }
    }
}