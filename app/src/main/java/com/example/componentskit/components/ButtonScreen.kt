package com.example.componentskit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Button Screen") },
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
            Box(
                modifier = Modifier
                    .background(Color(0xFFF44336))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Esto es un IconButton")
            }

            Row {
                //IconButton: tiene un tamaño por defecto y por mucho que aumente el icono del
                //contenido, si no aumento el tamaño del botón, no se va a dar cuenta.
                IconButton(
                    { println("Soy un icon button") },
                    modifier = Modifier.size(90.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "Icon Button",
                        modifier = Modifier.size(90.dp)
                    )
                }

                //Cambiamos el color con tint
                IconButton(
                    { println("Soy un icon button") },
                    modifier = Modifier.size(90.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Icon Button",
                        modifier = Modifier.size(90.dp),
                        tint = Color(0xFF009688)
                    )
                }

                IconButton(
                    { println("Soy un icon button") },
                    modifier = Modifier.size(90.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Icon Button",
                        modifier = Modifier.size(90.dp),
                        tint = Color(0xFFC30C0C)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFFF44336))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Esto es un ElevatedButton")
            }

            /* A un ElevatedButton se le puede cambiar:
             * Color con @colors: se puede cambiar el color tanto del botón como del contenido
             * Tamaño: con Modifier. Hay que especificar el ancho y alto. Con size se convierte
               en un círculo. Cuidado con el orden del padding para que el botón no se haga más
               pequeño.
             * Elevacion: elevation
             */

            ElevatedButton(
                colors = ButtonDefaults.buttonColors(Color.LightGray,
                    contentColor = Color.Black),
                modifier = Modifier
                    .padding(50.dp, 10.dp)
                    .width(300.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(5.dp) ,
                onClick = { println("Soy un elevated button")}) {
                Text("Elevated button")
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFFF44336))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("OutlinedButton")
            }

            /*Botón que solo tiene dibujados los bordes. Se puede cambiar:
            * Color: colors. Por defecto es transparente pero entonces no veo el texto.
              El texto se cambia en "contentColor"
            * Borde: border. Pero el elemento ButtonDefaults.outlinedButtonBorder ya tiene unos
              parámetros predeterminados. Para usar la estructura pero cambiar los valores, tengo que
              copiarla o crear una nueva instancia BorderStroke (un nuevo elemento con otros valores)
             */
            OutlinedButton(

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Magenta
                ),
                //border = ButtonDefaults.outlinedButtonBorder(enabled = true).copy(5.dp),
                border = BorderStroke(5.dp, Color.Magenta), //Esto es igual a lo anterior
                onClick = {println("Soy un outlined button")}) {
                Text("Soy un outlined button")
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFFF44336))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("FilledTonalButton")
            }
            FilledTonalButton(onClick = {println("Soy un FilledTonalButton") }) {
                Text("Soy un filled tonal button")
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFFF44336))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("FilledIconButton")
            }
            FilledIconButton(onClick = {println("Soy un FilledIconButton") }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "")
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFFF44336))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Botón deshabilitado")
            }

            /*Propiedad enabled. Lo tienen todos los botones y permite deshabilitarlos hasta que
             se cumpla una condición (por ejemplo: en pantalla de login, hasta que se introduzca
             login y password*/
            FilledTonalButton(
                enabled = false,
                onClick = {println("Soy un FilledTonalButton") }) {
                Text("Soy un filled tonal button")
            }
        }
    }
}
