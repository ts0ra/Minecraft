package com.ts0ra.minecraft.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ts0ra.minecraft.ui.screen.AboutScreen
import com.ts0ra.minecraft.ui.screen.DetailScreen
import com.ts0ra.minecraft.ui.screen.HomeScreen

@Composable
fun MinecraftAppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onMenuClick = {
                    navController.navigate("about")
                },
                onMobClick = { mobId ->
                    navController.navigate("detail/$mobId")
                }
            )
        }
        composable("about") {
            AboutScreen(
                onMenuClick = {
                    navController.navigateUp()
                }
            )
        }
        composable(
            route = "detail/{mobId}",
            arguments = listOf(navArgument("mobId") { type = NavType.IntType })
        ) { backStackEntry ->
            val mobId = backStackEntry.arguments?.getInt("mobId") ?: -1
            DetailScreen(
                mobId = mobId,
                onMenuClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}