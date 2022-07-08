package com.example.suitmedia.presentasion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SetupNavGraph(
    navController: NavHostController)
{
    NavHost(
        navController = navController,
        startDestination = SCREEN_ROUTE )
    {
        screenGraph(navController = navController)
    }

}