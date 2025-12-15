package com.example.componentskit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdsClick
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.SpaceBar
import androidx.compose.material.icons.filled.SwitchLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Kit de componentes") }) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            ItemComponent(
                "Text",
                Icons.Default.Edit,
                Modifier.clickable {
                    navController.navigate(Screens.TextScreen.name)
                }
            )
            ItemComponent(
                "Icon",
                Icons.Default.Face,
                Modifier.clickable {
                    navController.navigate(Screens.IconScreen.name)
                }
            )
            ItemComponent(
                "Button",
                Icons.Default.AdsClick,
                Modifier.clickable {
                    navController.navigate(Screens.ButtonScreen.name)
                }
            )
            ItemComponent(
                "TextField",
                Icons.Default.SpaceBar,
                Modifier.clickable {
                    navController.navigate(Screens.TextFieldScreen.name)
                }
            )
            ItemComponent(
                "CheckBox",
                Icons.Default.CheckBox,
                Modifier.clickable {
                    navController.navigate(Screens.CheckBoxScreen.name)
                }
            )
            ItemComponent(
                "Switch",
                Icons.Default.SwitchLeft,
                Modifier.clickable {
                    navController.navigate(Screens.SwitchScreen.name)
                }
            )
            ItemComponent(
                "RadioButton",
                Icons.Default.RadioButtonChecked,
                Modifier.clickable {
                    navController.navigate(Screens.RadioButtonScreen.name)
                }
            )
            ItemComponent(
                "Image",
                Icons.Default.Image,
                Modifier.clickable {
                    navController.navigate(Screens.ImageScreen.name)
                }
            )

            ItemComponent(
                "Card",
                Icons.Default.Contacts,
                Modifier.clickable {
                    navController.navigate(Screens.CardScreen.name)
                }
            )

            ItemComponent(
                "LazyColumn",
                Icons.Default.Menu,
                Modifier.clickable {
                    navController.navigate(Screens.LazyColumnScreen.name)
                }
            )

            ItemComponent(
                "Material3 Design",
                Icons.Default.Brush,
                Modifier.clickable {
                    navController.navigate(Screens.Material3Screen.name)
                }
            )

        }
    }

}