package com.example.componentskit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.componentskit.R

//Componente Image
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreen(navController: NavHostController) {
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
                title = { Text("Image Screen") })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

            //Ejemplo 1: Image
            //Recibe parámetros: painter y contentDescription
            //painter: es un tipo painterResource(id de imagen en res/drawable)
            //contentDescription: es una cadena de texto que describe la imagen

            Image(
                painter = painterResource(R.drawable.basketball),
                contentDescription = "Descripción de la imagen"
                )

            //Spacer
            Spacer(modifier = Modifier.height(24.dp))

            //Ejemplo 2: Image con otros parámetros.
            //Modifier: fillMaxWidth()
            //Modifier.Scale: desde donde se pinta, amplia alrededor
           /* Image(
                painter = painterResource(R.drawable.basketball),
                contentDescription = "Descripción de la imagen",
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(3f)
            )*/

            //Spacer
            Spacer(modifier = Modifier.height(24.dp))

            //Ejemplo 3: Image: tamaño con scale
            //Size(200.dp): la amplia hacia abajo desde donde se pinta
            Image(
                painter = painterResource(R.drawable.basketball),
                contentDescription = "Descripción de la imagen",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp)
            )
        }
    }
}