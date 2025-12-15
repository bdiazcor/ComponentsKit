package com.example.componentskit

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.componentskit.components.ButtonScreen
import com.example.componentskit.components.CardScreen
import com.example.componentskit.components.CheckBoxScreen
import com.example.componentskit.components.IconScreen
import com.example.componentskit.components.ImageScreen
import com.example.componentskit.components.LazyColumnScreen
import com.example.componentskit.components.Material3Screen
import com.example.componentskit.components.RadioButtonScreen
import com.example.componentskit.components.SwitchScreen
import com.example.componentskit.components.TextFieldScreen
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
        composable(Screens.ButtonScreen.name) { ButtonScreen(navController) }
        composable(Screens.TextFieldScreen.name) { TextFieldScreen(navController) }
        composable(Screens.CheckBoxScreen.name) { CheckBoxScreen(navController) }
        composable(Screens.SwitchScreen.name) { SwitchScreen(navController) }
        composable(Screens.RadioButtonScreen.name) { RadioButtonScreen(navController) }
        composable(Screens.ImageScreen.name) { ImageScreen(navController) }
        composable(Screens.CardScreen.name) { CardScreen(navController) }
        composable(Screens.LazyColumnScreen.name) { LazyColumnScreen(navController) }
        composable(Screens.Material3Screen.name) { Material3Screen(navController) }

    }

}