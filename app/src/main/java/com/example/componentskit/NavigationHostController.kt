package com.example.componentskit

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.componentskit.components.IconScreen
import com.example.componentskit.components.TextScreen

@Composable
fun NavigationHostController() {

    //Declaramos en controlador de navegación: navController
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = Screens.HomeScreen.name){
        composable (Screens.HomeScreen.name) { HomeScreen(navController) }
        composable(Screens.TextScreen.name) { TextScreen(navController) }
        composable(Screens.IconScreen.name) { IconScreen(navController) }
    }

}