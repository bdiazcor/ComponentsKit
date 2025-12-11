package com.example.componentskit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadioButtonScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver a pantalla Home"
                        )
                    }
                },
                title = { Text("Radio Button Screen") })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            //Ejemplo 1: Radio Button
            //Parámetros obligatorios: selected (estado de control) y onClick (acción)
            //Como en Checkbox() y Switch(), se declara una variable de estado que se asigna al parámetro
            var selectedOption by remember { mutableStateOf(false) }

            RadioButton(
                selected = selectedOption,
                onClick = { selectedOption = !selectedOption }
            )

            //Horizontal Divider
            HorizontalDivider()

            //Ejemplo 2: Radio Button más real.
            //Los Radio Button no se utilizan solos. Al igual que los CheckBox() suelen ir al lado de un texto que es el que se pulsa para seleccionar la opción
            var selectedOption2 by remember { mutableStateOf(false) }


            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption2,
                    onClick = { selectedOption2 = !selectedOption2 }
                )
                Text("Opción 1") //Se podría hacer el texto .clickable con la misma lógica que el onClick del RadioButton
            }

            //Horizontal Divider
            HorizontalDivider()

            //Ejemplo 3: Los Radio Buttons suelen venir en conjunto con una sola opción elegible
            //Pero es un poco complejo crear un estado por cada opción
            //Creamos una variable de estado para la opción: optionSelected. Puede ser un número, un texto, una sealed class
            //El estado de control (selected) ahora dependerá de la opción seleccionada
            var optionSelected by remember { mutableIntStateOf(1) }

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (optionSelected == 1),
                    onClick = { optionSelected = 1 }
                )
                Text("Opción 1")            }

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (optionSelected == 2),
                    onClick = { optionSelected = 2 }
                )
                Text("Opción 2")
            }

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (optionSelected == 3),
                    onClick = { optionSelected = 3 }
                )
                Text("Opción 3")
            }

            //Horizontal Divider
            HorizontalDivider()

            //Ejemplo 4: Radio Button con estilo
            //Otros parámetros comunes: colors
            var selectedOption4 by remember { mutableStateOf(false) }

            RadioButton(
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Blue,
                    disabledSelectedColor = Color.Green,
                    disabledUnselectedColor = Color.Yellow
                ),
                enabled = true, //Si enables = false, se activa los colores "disabled..."
                selected = selectedOption4,
                onClick = { selectedOption4 = !selectedOption4 }
            )

        }

    }

}
