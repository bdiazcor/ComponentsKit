package com.example.componentskit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun AlertDialogScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Alert Dialog Screen") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    )
    { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            //Creamos un estado que nos permitirá controlar si mostramos el AlertDialog o no
            var mostrarDialogo by remember { mutableStateOf(false) }

            //IconButton de borrado: vamos a añadir un AlertDialog para asegurar que queremos borrar el elemento
            IconButton(
                onClick = {
                    mostrarDialogo = true //Cuando pulsamos el Iconbutton, mostramos el AlertDialog
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Icon Button",
                    modifier = Modifier.size(40.dp),
                    tint = Color.Red
                )
            }

            //Implementamos el AlertDialog dentro de un condicional según el estado
            if (mostrarDialogo) {
                AlertDialog(
                    onDismissRequest = { mostrarDialogo = false }, //Si pincho fuera del diálogo, se cierra
                    title = { Text("Eliminar") },
                    text = { Text("¿Estás seguro de que quieres eliminar este icono?") },
                    confirmButton = { //Botón de confirmación de borrado. Es un elemento obligatorio
                        TextButton(
                            onClick = {
                                println("Elemento borrado") //Aquí podríamos borrar el elemento
                                mostrarDialogo = false
                            }
                        ) {
                            Text( "Eliminar", color = Color.Red)
                        }
                    },
                    dismissButton = { //Botón de cancelar el borrado
                        TextButton(
                            onClick = { mostrarDialogo = false }
                        ) {
                            Text("Cancelar", color = Color(0xFF4CAF50))
                        }
                    }
                )
            }
        }
    }
}
