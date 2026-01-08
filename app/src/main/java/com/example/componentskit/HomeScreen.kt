package com.example.componentskit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.automirrored.filled.Notes
import androidx.compose.material.icons.filled.AdsClick
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Delete
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Kit de componentes") }) }
    ) { paddingValues ->

        //Creamos una lista de elementos de clase MenuItem para incluir dentro de una LazyColumn
        //La LazyColumn me va a permitir hacer scroll cuando los elementos crecen
        val menuItems = mutableListOf(
            MenuItem("Text", Icons.Default.Edit, Screens.TextScreen.name),
            MenuItem("Icon", Icons.Default.Face, Screens.IconScreen.name),
            MenuItem("Button", Icons.Default.AdsClick, Screens.ButtonScreen.name),
            MenuItem("TextField", Icons.Default.SpaceBar, Screens.TextFieldScreen.name),
            MenuItem("CheckBox", Icons.Default.CheckBox, Screens.CheckBoxScreen.name),
            MenuItem("Switch", Icons.Default.SwitchLeft, Screens.SwitchScreen.name),
            MenuItem(
                "RadioButton",
                Icons.Default.RadioButtonChecked,
                Screens.RadioButtonScreen.name
            ),
            MenuItem("Image", Icons.Default.Image, Screens.ImageScreen.name),
            MenuItem("Card", Icons.Default.Contacts, Screens.CardScreen.name),
            MenuItem("LazyColumn", Icons.Default.Menu, Screens.LazyColumnScreen.name),
            MenuItem("Material3 Design", Icons.Default.Brush, Screens.Material3Screen.name),
            MenuItem("AlertDialog", Icons.Default.Delete, Screens.AlertDialogScreen.name),
            MenuItem(
                "Toast",
                Icons.AutoMirrored.Filled.Message, Screens.ToastScreen.name
            ),
            MenuItem(
                "Snackbar",
                Icons.AutoMirrored.Filled.Notes, Screens.SnackbarScreen.name
            )
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(
                menuItems
            ) { menuItem ->
                ItemComponent(
                    menuItem.name,
                    menuItem.icon,
                    Modifier.clickable {
                        navController.navigate(menuItem.route)
                    }
                )
            }
        }

        //Implementación antigua mediante columna. La dejo comentada porque este es el formato de clase
        /*Column(modifier = Modifier.padding(paddingValues)) {
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

        }*/
    }
}