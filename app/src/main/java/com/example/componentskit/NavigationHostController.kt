package com.example.componentskit

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.componentskit.components.TextScreen

@Composable
fun NavigationHostController() {

    //Declaramos en controlador de navegación: navController
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable ("home") { HomeScreen(navController) }
        composable("text") { TextScreen(navController) }
    }

}