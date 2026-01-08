package com.example.componentskit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnackbarScreen(navController: NavHostController) {

    //Estado que gestiona la lógica del snarckbar (por ejemplo: cuando aparece, mensaje,...)
    val snackbarHostState = remember { SnackbarHostState() }

    //Ahora vamos a crear un alcance (scope) para poder corrutinas y efectos secundarios sin bloquear
    //el hilo principal de la aplicación
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Snackbar Screen") },
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
        },
        //snackbar es un atributo de Scaffold que nos permite mostrar un snackbar
        snackbarHost = {
            //SnackbarHost es un componente que nos permite controlar el snackbar
            SnackbarHost(
               hostState = snackbarHostState //le pasamos el estado que hemos creado
            ) {snackbardata ->
                //le pasamos los datos del snackbar. Datos proporcionados por el Scaffold
                Snackbar(
                    snackbarData = snackbardata,
                    shape = RoundedCornerShape(16.dp), //bordes redondeados
                    containerColor = Color(0xFF03A9F4), //color de fondo
                    contentColor = Color.White, //color del texto
                    actionColor = Color.Red, //color texto del botón de acción
                )
            }

        }
    )
    { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            //Botón que muestra un Snackbar
            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF009688)
                ),
                border = BorderStroke(2.dp, Color(0xFF009688)), //Esto es igual a lo anterior
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {

                    scope.launch {
                        val resultado = snackbarHostState.showSnackbar(
                            message = "Elemento eliminado", //Mensaje del snackbar
                            actionLabel = "Deshacer",//Botón de acción dentro del snackbar
                            duration = SnackbarDuration.Short //Duración del snackbar
                        )
                        //Cuando presionemos el botón lanzamos una corrutina
                        //.showSnackbar() es una función suspendida que muestra el snackbar por ello
                        //va dentro de una corrutina
                        when (resultado) {
                            SnackbarResult.ActionPerformed -> {
                                println("Elemento restaurado")
                                //Si el usuario presionó "Deshacer", restaura elemento eliminado
                            }

                            SnackbarResult.Dismissed -> {
                                println("Elemento eliminado")
                                //Si el usuario no hace nada, el snackbar desaparece tras duration
                            }
                        }
                    }
                }) {
                Text("Haz click para mostrar un Snackbar")
            }
        }
    }
}
