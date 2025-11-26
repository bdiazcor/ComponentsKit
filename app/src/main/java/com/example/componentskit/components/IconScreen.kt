package com.example.componentskit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.sharp.Phone
import androidx.compose.material.icons.twotone.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.componentskit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconScreen(navController: NavHostController) {
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
                title = { Text("Icon Screen") })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

            /* En el componente Icon es obligatorio selecciona una imagen (painter,
             bitmap, imageVector, etc) y añadir un contentDescription (por temas de
             accesibilidad.
             Aparte, si damos ctrl + espacio: podemos ver los atributos adicionales
             de un icono:
             - tint = Color.Green -> cambia color
             - modifier = Modifier.size(100.dp) -> cambia el tamaño
             - modifier = Modifier.padding(18.dp)
             */

            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Icono lápiz",
                tint = Color.Green,
                modifier = Modifier
                    .padding(18.dp)
                    .size(100.dp)


            )

            HorizontalDivider()

            Row {
                //Librería Default
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Icono lápiz por defecto",
                    modifier = Modifier
                        .padding(18.dp)
                        .size(100.dp)
                )
                //Librería Filled
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Icono lápiz filled",
                    modifier = Modifier
                        .padding(18.dp)
                        .size(100.dp)
                )

                //Librería Outlined
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Icono lápiz outlined",
                    modifier = Modifier
                        .padding(18.dp)
                        .size(100.dp)
                )

            }
            Row {
                //Librerías Sharp y Rounded
                Icon(
                    imageVector = Icons.Sharp.Phone,
                    contentDescription = "Icono lápiz redondeado",
                    modifier = Modifier
                        .padding(18.dp)
                        .size(100.dp)
                )
                Icon(
                    imageVector = Icons.Rounded.Phone,
                    contentDescription = "Icono lápiz redondeado",
                    tint = Color(0xFFFF5722),
                    modifier = Modifier
                        .padding(18.dp)
                        .size(100.dp)
                )

                //Instala dependencias para tener un listado más completo de iconos
                Icon(
                    Icons.Default.Bathtub,
                    contentDescription = "Icono extendido",
                    modifier = Modifier
                        .padding(18.dp)
                        .size(100.dp)
                )
            }

            Row {

                //Icono de 2 colores
                Icon(
                    imageVector = Icons.TwoTone.Image,
                    contentDescription = "Icono de dos colores",
                    modifier = Modifier
                        .padding(18.dp)
                        .size(100.dp)
                )
                //Icono de tipo vector asset
                Icon(painter = painterResource(R.drawable.ic_twotone_image_24),
                    contentDescription = "Icono de la librería de vectores",
                    modifier = Modifier
                        .padding((18.dp))
                        .size(100.dp)
                )
            }


        }
    }
}

@Preview (showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconScreenPreview() {
           Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = {
                        }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Volver a pantalla Home"
                            )
                        }
                    },
                    title = { Text("Icon Screen") })
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {

                /* En el componente Icon es obligatorio selecciona una imagen (painter,
                 bitmap, imageVector, etc) y añadir un contentDescription (por temas de
                 accesibilidad.
                 Aparte, si damos ctrl + espacio: podemos ver los atributos adicionales
                 de un icono:
                 - tint = Color.Green -> cambia color
                 - modifier = Modifier.size(100.dp) -> cambia el tamaño
                 - modifier = Modifier.padding(18.dp)
                 */

                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Icono lápiz",
                    tint = Color.Green,
                    modifier = Modifier
                        .padding(18.dp)
                        .size(100.dp)


                )

                HorizontalDivider()

                //Tenemos opciones: Default, Filled, Outlined, Sharp, Rounded

                Row {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Icono lápiz por defecto",
                        modifier = Modifier
                            .padding(18.dp)
                            .size(100.dp)
                    )

                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Icono lápiz filled",
                        modifier = Modifier
                            .padding(18.dp)
                            .size(100.dp)
                    )

                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "Icono lápiz outlined",
                        modifier = Modifier
                            .padding(18.dp)
                            .size(100.dp)
                    )

                }
                Row {
                    Icon(
                        imageVector = Icons.Sharp.Phone,
                        contentDescription = "Icono lápiz redondeado",
                        modifier = Modifier
                            .padding(18.dp)
                            .size(100.dp)
                    )
                    Icon(
                        imageVector = Icons.Rounded.Phone,
                        contentDescription = "Icono lápiz redondeado",
                        tint = Color(0xFFFF5722),
                        modifier = Modifier
                            .padding(18.dp)
                            .size(100.dp)
                    )

                    //Instala dependencias para tener un listado más completo de iconos
                    Icon(
                        Icons.Default.Bathtub,
                        contentDescription = "Icono extendido",
                        modifier = Modifier
                            .padding(18.dp)
                            .size(100.dp)
                    )
                }

                //Icono de 2 colores
                Row {
                    Icon(
                        imageVector = Icons.TwoTone.Image,
                        contentDescription = "Icono de dos colores",
                        modifier = Modifier
                            .padding(18.dp)
                            .size(100.dp)
                    )
                    //Icono de tipo vector asset
                    Icon(painter = painterResource(R.drawable.ic_twotone_image_24),
                        contentDescription = "Icono de la librería de vectores",
                        modifier = Modifier
                            .padding((18.dp))
                            .size(100.dp)
                    )
                }


            }
        }
    }
