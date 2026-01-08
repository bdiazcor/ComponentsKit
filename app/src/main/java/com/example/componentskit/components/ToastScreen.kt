package com.example.componentskit.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToastScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Toast Screen") },
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

            //Creamos una variable con el contexto actual para usar el Toast
            val context = LocalContext.current

            //Cada vez que se presione el botón se va a mostrar un mensaje tipo Toast
            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF009688)
                ),
                border = BorderStroke(2.dp, Color(0xFF009688)), //Esto es igual a lo anterior
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {

                    //Toast
                    Toast.makeText( //Crea la instancia del mensaje Toast
                        context, //Contexto, en este caso ToastScreen
                        "Soy un Toast",  //Texto del mensaje Toast
                        Toast.LENGTH_SHORT //Duración del mensaje Toast
                    ).show()  //Muestra el mensaje Toast


                }) {
                Text("Haz click para mostrar un Toast")
            }
        }
    }
}
