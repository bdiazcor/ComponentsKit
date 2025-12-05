package com.example.componentskit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckBoxScreen(navController: NavHostController) {
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
                title = { Text("Check Box Screen") })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            //Ejemplo1: Checkbox
            //Defino el estado del checked. Por defecto está desabilitado (false)
            var checkedValue by remember { mutableStateOf(false) }

            //Los parámetros obligatorios son: checked (boolean) y onCheckedChange(lambda)
            Checkbox(
                checked = checkedValue,
                //Acción que devuelve un boolean: true si previamente estaba "unchecked"
                //y false si estaba checked. Este boolean (it), se lo asigno a la variable
                //de estado para pintar el nuevo estado y recordarla para la próxima acción

                onCheckedChange = {
                    checkedValue = it
                },
                enabled = true,
                //Cambio de colores con colors
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Yellow,
                    uncheckedColor = Color.Green,
                    checkmarkColor = Color.Blue
                )
            )

            //Spacer añade una espacio en pantalla
            Spacer(modifier = Modifier.height(50.dp))

            HorizontalDivider()

            //Spacer añade una espacio en pantalla
            Spacer(modifier = Modifier.height(50.dp))

            //Ejemplo2: Cambio el tamaño
            var checkedValue2 by remember { mutableStateOf(false) }

            Checkbox(
                checked = checkedValue2,

                onCheckedChange = {
                    checkedValue2 = it
                },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Yellow,
                    uncheckedColor = Color.Green,
                    checkmarkColor = Color.Blue
                ),
                //para cambiar el tamaño de un CheckBox le doy espacio en pantalla con
                //.size y le hago crecer con .scale. Scale es un float
                modifier = Modifier
                    .scale(3f)
                    .size(100.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(50.dp))

            //Ejemplo3: Modificar un checkbox pulsando un texto.
            //Se hace incluyen checkbox en una fila y haciendo
            //la fila .clickable con una acción de cambio de estado
            var checkedValue3 by remember { mutableStateOf(false) }

            Row (modifier = Modifier.padding(16.dp)
                .clickable{
                    checkedValue3 = !checkedValue3
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedValue3,
                    //Acción que devuelve un boolean: true si previamente estaba "unchecked"
                    //y false si estaba checked. Este boolean (it), se lo asigno a la variable
                    //de estado para pintar el nuevo estado y recordarla para la próxima acción

                    onCheckedChange = {
                        checkedValue3 = it
                    },
                    enabled = true,
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Yellow,
                        uncheckedColor = Color.Green,
                        checkmarkColor = Color.Blue
                    )
                )
                Text("Checkbox 3")


            }

        }

    }
}