package com.example.componentskit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Text Field Screen") },
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
            //Textfield()
            var text by rememberSaveable { mutableStateOf(value = "") }
            TextField(
                modifier = Modifier.padding(16.dp),
                value = text, onValueChange = { newValue: String
                    ->
                    text = newValue
                }
            )

            HorizontalDivider()

            /* Algunos parámetros interesante de TextField:
            * label: "Introduce tu nombre
            * */

            var text2 by rememberSaveable { mutableStateOf("") }

            TextField(
                modifier = Modifier.padding(16.dp),
                label = { Text("Introduce tu nombre") },
                value = text2,
                onValueChange = { newValue: String -> text2 = newValue }
            )

            HorizontalDivider()

            // OutlinedTextField()

            var text3 by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier.padding(16.dp),
                label = { Text("Introduce tu nombre") },
                value = text3,
                onValueChange = { newValue: String -> text3 = newValue }
            )

            HorizontalDivider()

            /* OutlinedTextField(): parámatros para configurar una sola línea:
            * singleLine = true
            */

            var text4 by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier.padding(16.dp),
                label = { Text("Introduce tu nombre") },
                value = text4,
                onValueChange = { newValue: String -> text4 = newValue },
                singleLine = true
            )

            /* OutlinedTextField(): parámetros para transformar el texto:
            * visualTranformation = PasswordVisualTransformation().
            * Se usa para ocultar las letras cuando escribimos una paswword.
            */

            var text5 by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier.padding(16.dp),
                label = { Text("Password") },
                value = text5,
                onValueChange = { newValue: String -> text5 = newValue },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation()
            )
            HorizontalDivider()

            /* OutlinedTextField(): trailingIcon para mostrar u ocultar contraseña.
            * Puede ser de diferentes tipos pero lo normal es que sea un
            * IconButton()
            * Para poder ocultar y mostrar la contraseña:
            * 1) Necesitamos otro estado:
            * var showPassword by remember { mutableStateOf(false) }
            * 2) Configuramos el trailinIcon con la acción
            * 3) Modificamos los elementos que Jetpack Compose pinta:
            * - trailingIcon
            * - visualTransformation del texto
            */

            var text6 by rememberSaveable { mutableStateOf("") }

            //Variable que controla si mostramos u ocultamos contraseña
            var showPassword by rememberSaveable { mutableStateOf(false) }

            OutlinedTextField(
                trailingIcon = {
                    IconButton(onClick = {
                        //Si showPassword es true cambia a false y viceversa
                        showPassword = !showPassword
                    }) {
                        //Seleccionamos iconos diferentes para mostrar u ocultar
                        // contraseña
                        if (showPassword) {
                            Icon(
                                Icons.Default.Visibility,
                                contentDescription = "Contraseña visible"
                            )
                        } else
                            Icon(
                                Icons.Default.VisibilityOff,
                                "Contraseña oculta"
                            )
                    }
                },
                modifier = Modifier.padding(16.dp),
                label = { Text("Password") },
                value = text6,
                onValueChange = { newValue: String -> text6 = newValue },
                singleLine = true,
                //Mostramos texto visible u oculto según estado de showPassword
                visualTransformation =
                    if (showPassword) VisualTransformation.None
                    else PasswordVisualTransformation()
            )

        }
    }
}
