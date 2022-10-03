package com.example.gothouses.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gothouses.models.House
import com.example.gothouses.screens.HomePage
import com.example.gothouses.screens.HouseDetail
import com.google.gson.Gson

@ExperimentalComposeUiApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Route.HomePage){
            HomePage(navController = navController)
        }
        composable(
            Route.HouseDetail + "/{house}",
            arguments = listOf(
                navArgument("house") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("house")?.let { json ->
                val house = Gson().fromJson(json, House::class.java)
                HouseDetail(navController = navController, house = house)
            }
        }
    }
}