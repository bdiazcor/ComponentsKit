package com.example.componentskit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.componentskit.R

//Componente Image
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardScreen(navController: NavHostController) {
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
                title = { Text("Card Screen") })
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp) ) {//Padding interno de la columna

            //Ejemplo 1: Card
            //Recibe parámetros: painter y contentDescription
            //painter: es un tipo painterResource(id de imagen en res/drawable)
            //contentDescription: es una cadena de texto que describe la imagen
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(4.dp), //Asignamos una sombra a la tarjeta para efecto de profundidad
                colors = CardDefaults.cardColors(containerColor = Color(0xFF9987BB))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.card_image),
                        contentDescription = "Descripción de la imagen",
                        modifier = Modifier
                            .fillMaxWidth() //Imagen ocupa el ancho completo
                            .height(180.dp) //Altura de la imagen
                            .clip(RoundedCornerShape(8.dp)), //Esquinas redondeadas
                        contentScale = ContentScale.Crop //Recortar imagen para rellenar espacios
                    )
                    Spacer(modifier = Modifier.height(4.dp)) //Espacio entre la imagen y el texto
                    Text(
                        text = "Título de la tarjeta",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                        )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Descripción de la tarjeta. Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Button(
                        onClick = {},
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Ver más")
                    }

                }

            }

            //Ejemplo 2: Elevated Card
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                //La defaultElevation por defecto es 1 dp. Para que se vea más profunda jugamos con los dps
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Título de la tarjeta",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Este es un ejemplo de Elevated Card",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

            }

            //Ejemplo 3: Outlined Card
            //En cuanto a sus características, algunas de las más comunes son: forma (shape)
            // y diseño del borde (border).
            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, color = Color(0xFF3F51B5))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Título de la tarjeta",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Este es un ejemplo de Outlined Card y se usa para resaltar" +
                                " información sin sobrecargar la UI",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Ver más")
                    }
                }

            }



        }
    }
}