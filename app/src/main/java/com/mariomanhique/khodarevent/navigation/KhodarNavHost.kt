package com.mariomanhique.khodarevent.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mariomanhique.khodarevent.presentation.screens.splash.navigation.splashRoute
import com.mariomanhique.khodarevent.ui.KhodarAppState
import com.mariomanhique.khoevent.presentation.screens.home.navigation.navigateToHome

@Composable
fun KhodarNavHost(
    appState: KhodarAppState,
    startDestination: String = splashRoute,
    onMenuClicked: () -> Unit = {},
    paddingValues: PaddingValues
) {

    val navController = rememberNavController();

    NavHost(navController = navController, startDestination = startDestination){

        splashRoute{
    navController.navigateToHome()
        }

    }

}