package com.example.componentskit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//Personalizamos algunos elementos con MAterial3
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3Screen(navController: NavHostController) {
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
                title = { Text("Aplicación de Material Theme") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //Usamos el parámetro style pero ahora no usamos
            //TextStyle() sino que vamos a llamar a MaterialTheme

            Text(
                text = "Soy un texto",
                //Tipografía
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            //Aplicamos otros estilos
            Text(
                text = "Encabezado grande",
                style = MaterialTheme.typography.displayLarge
            )

            Text(
                text = "Cuerpo del texto",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Etiqueta pequeña",
                style = MaterialTheme.typography.labelSmall
            )

            Text(
                text = "Soy un texto cambiando valores por defecto",
                //Tipografía
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = FontFamily.Serif,
                    fontSize = 55.sp,
                    fontWeight = FontWeight.Thin,
                    lineHeight = 50.sp
                ),
                color = MaterialTheme.colorScheme.primary
            )


        }
    }
}