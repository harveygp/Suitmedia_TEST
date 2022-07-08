package com.example.suitmedia.presentasion.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.suitmedia.presentasion.screen1.firstScreen
import com.example.suitmedia.presentasion.screen2.secondScreen
import com.example.suitmedia.presentasion.screen3.thirdScreen

fun NavGraphBuilder.screenGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.screen1.route,
        route = SCREEN_ROUTE
    ) {
        composable(
            route = Screen.screen1.route
        ) {
            firstScreen(navController = navController)
        }

        composable(
            route = Screen.screen2.route,
        ) {
            secondScreen(
                navController = navController)
        }

        composable(
            route = Screen.screen3.route
        ) {
            thirdScreen(navController = navController)
        }
    }
}