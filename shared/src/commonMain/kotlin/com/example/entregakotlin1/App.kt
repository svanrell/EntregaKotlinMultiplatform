package com.example.entregakotlin1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import entregakotlin1.shared.generated.resources.Res
import entregakotlin1.shared.generated.resources.playa

@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize() // ocupa toda la ventana
                .padding(16.dp), // margen alrededor
            verticalArrangement = Arrangement.spacedBy(16.dp) // separacion entre tarjetas
        ) {
            Tarjeta(
                nombre = "Elvira Ocaña Rodríguez",
                cargo = "Desarrolladora DAM",
                correo = "example@example.com",
                ciudad = "Palma",
                colorFondo = Color.White
            )
            Tarjeta(
                nombre = "Ginés Ocaña Rodríguez",
                cargo = "Desarrollador DAM",
                correo = "example2@example.com",
                ciudad = "Palma",
                colorFondo = Color(0xFFF8FAFC) // fondo un poco diferente para probar
            )
            Tarjeta(
                nombre = "Gustavo Ocaña Rodríguez",
                cargo = "Desarrollador DAM",
                correo = "example3@example.com",
                ciudad = "Palma",
                colorFondo = Color.White
            )
        }
    }
}

// Componente reutilizable para cada tarjeta
@Composable
fun Tarjeta(
    nombre: String,
    cargo: String,
    correo: String,
    ciudad: String,
    colorFondo: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = colorFondo),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // sombra suave
    ) {
        Row(
            modifier = Modifier.padding(16.dp), // padding interior
            verticalAlignment = Alignment.CenterVertically, // alinea verticalmente foto y texto
            horizontalArrangement = Arrangement.spacedBy(16.dp) // espacio entre foto y textos
        ) {
            Image(
                painter = painterResource(Res.drawable.playa), // imagen de resources
                contentDescription = null,
                contentScale = ContentScale.Crop, // ajusta la imagen sin deformar
                modifier = Modifier
                    .size(80.dp) // tamaño cuadrado
                    .clip(CircleShape) // la corta en circulo
            )

            Column(
                modifier = Modifier.weight(1f) // ocupa el ancho restante
            ) {
                Text(
                    text = nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = cargo,
                    color = Color(0xFFC05C46), // color teja de clase
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 8.dp) // separacion arriba y abajo
                )

                Row {
                    Text("Correo: ", fontWeight = FontWeight.Bold)
                    Text(correo)
                }

                Row {
                    Text("Ciudad: ", fontWeight = FontWeight.Bold)
                    Text(ciudad)
                }
            }
        }
    }
}
