package com.example.componentskit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//Componente Image
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyColumnScreen(navController: NavHostController) {
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
                title = { Text("LazyColumn Screen") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {//Padding interno de la columna

            //Ejemplo: LazyColumn
            //Permite organizar lista de manera vertical
            //Sólo los elementos visibles se renderizan en la pantalla
            //Mejora el rendimiento, principalmente de listas largas

            //Creamos una lista de 100 elemento.
            //"it" contiene el índice actual de cada elemento
            val elementosLista = List(100) { "Elemento número $it" }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)

            ) {


                item {
                    Text(
                        text = "Encabezado de la lista",
                        fontSize = 24.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )

                }

                //LazyColumn usa la funcion predefinida items() para recorrer la lista
                //y renderizar los elementos en la pantalla de manera vertical.
                items(elementosLista) { elemento ->
                    Text(
                        text = elemento,
                        fontSize = 20.sp
                    )
                }

                item {
                    Text(
                        text = "Pie de la lista",
                        fontSize = 24.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                }

            }

        }
    }
}