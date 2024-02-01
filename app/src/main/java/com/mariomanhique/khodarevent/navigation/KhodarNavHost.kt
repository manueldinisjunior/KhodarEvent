package com.mariomanhique.khodarevent.navigation

//import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.mariomanhique.khodarevent.presentation.screens.home.navigation.homeRoute
import com.mariomanhique.khodarevent.presentation.screens.home.navigation.navigateToHome
//import androidx.navigation.compose.rememberNavController
import com.mariomanhique.khodarevent.presentation.screens.splash.navigation.splashRoute
import com.mariomanhique.khodarevent.ui.KhodarAppState


@Composable
fun KhodarNavHost(
    appState: KhodarAppState,
    startDestination: String = splashRoute,
    onMenuClicked: () -> Unit = {},
    paddingValues: PaddingValues,
) {

    val navController = appState.navController

    NavHost(navController = navController, startDestination = startDestination){

        splashRoute{
            navController.navigateToHome()
        }

        homeRoute(
            onMenuClicked = onMenuClicked,
            navigateToEventDetails = {}
        )

    }




}


