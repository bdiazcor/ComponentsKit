package com.example.componentskit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Representación gráfica de cada elemento del menú de HomeScreen
@Composable
fun ItemComponent(name: String, icon: ImageVector, modifier: Modifier) {

    Row (modifier = modifier.fillMaxWidth()
        .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        Row {
            Icon(imageVector=icon,
                "icon")
            Text(name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 12.dp))
        }
        Box {
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Ir al detalle del componente")
        }
    }
}

