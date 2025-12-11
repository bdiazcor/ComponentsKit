package com.example.componentskit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwitchScreen(navController: NavHostController) {
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
                title = { Text("Switch Screen") })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            //Ejemplo1: Switch
            //Parámetros obligatorios: checked (estado de control) y onCheckedChange (acción)
            //Como en Checkbox(), se declara una variable de estado que se asigna al parámetro
            //Otros parámetros comunes: colors
            var checkedValue by remember { mutableStateOf(false) } //Este estado normalmente no va aquí. Va en un estado general.

            Switch(
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Green,
                    checkedTrackColor = Color.Yellow,
                    uncheckedThumbColor = Color.Red,
                    uncheckedTrackColor = Color.Blue
                ),
                modifier = Modifier.padding(16.dp), //Google, en su sistema de diseño recomienda usar múltiplos de 8
                checked = checkedValue,
                onCheckedChange = { checkedValue = it }
            )

            //Horizontal Divider
            HorizontalDivider()

            //Ejemplo2: Switch más real.
            //Los Switch no se utilizan solos. Al igual que los CheckBox() suelen ir al lado de un texto
            var checkedValue2 by remember { mutableStateOf(false) }

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(16.dp).fillMaxWidth()
            ) {
                Text("Habilitar notificaciones")
                Switch(
                    modifier = Modifier.padding(16.dp),
                    checked = checkedValue2,
                    onCheckedChange = {checkedValue2=it}
                )
            }

        }

    }

}
