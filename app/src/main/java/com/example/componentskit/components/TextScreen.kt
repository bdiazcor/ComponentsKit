package com.example.componentskit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

/**
 * Pantalla didáctica diseñada para demostrar las capacidades del componente [Text].
 *
 * Esta función presenta una colección de ejemplos prácticos sobre cómo manipular y estilizar
 * texto en Jetpack Compose, organizados de menor a mayor complejidad:
 *
 * 1. **Propiedades Directas:** Modificación básica de parámetros individuales como `fontSize`.
 * 2. **Textos Largos:** Comportamiento de párrafos extensos (Lorem Ipsum) y saltos de línea automáticos.
 * 3. **Objeto [TextStyle]:** Uso de un objeto de estilo para agrupar configuraciones (color, peso, tamaño),
 * promoviendo un código más limpio y reutilizable frente a las propiedades sueltas.
 * 4. **Texto Enriquecido ([buildAnnotatedString]):** Introducción a [SpanStyle] y `withStyle` para aplicar
 * formatos diferentes (como negritas) a palabras específicas dentro de una misma frase.
 *
 * **Navegación:**
 * Incluye una [TopAppBar] con un botón de retroceso que invoca a [navController.popBackStack].
 *
 * @param navController Controlador necesario para gestionar la navegación de vuelta al menú principal.
 * @see Text
 * @see TextStyle
 * @see SpanStyle
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextScreen(navController: NavHostController) {
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
                title = { Text("Text Screen") })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

            //Ejemplo de texto, modificando el parámentro de tamaño de texto
            Text(
                "Esto es un texto", fontSize = 30.sp,
                modifier = Modifier.padding(16.dp)
            )

            HorizontalDivider()

            /*Ejemplo de texto usando Lorem ipsum. Nos sirve para probar como
              las cadenas de texto se comporta si añadimos textos más largo.*/
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                modifier = Modifier.padding(16.dp)
            )

            HorizontalDivider()

            /*TextStyle() nos permite agrupar todas las propiedades de formato en un
            solo objeto (style = TextStyle(...)), mientras que sin TextStyle tendríamos
            que poner esas mismas propiedades sueltas directamente en el Text;
            el resultado es el mismo, pero usar TextStyle hace el código más limpio
            y organizado.*/
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Mi nombre es Beatriz y vivo en Madrid",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            )

            HorizontalDivider()

            /* - buildAnnotatedString()→ crea un texto en el que podemos aplicar formatos
                                         diferentes a partes distintas.
               - append() → Añade un fragmento de texto dentro del texto completo.
               - withStyle() → Agrupa un fragmento de texto para aplicarle un estilo concreto.
               - SpanStyle() → Define el estilo (color, tamaño, grosor, etc.)
                            que se aplicará a ese fragmento.*/

            Text(
                modifier = Modifier.padding(16.dp),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 20.sp
                        )
                    )
                    {
                        append("Mi nombre es ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Beatriz")
                    }
                    append(" y vivo en Madrid")
                }
            )
        }
    }
}