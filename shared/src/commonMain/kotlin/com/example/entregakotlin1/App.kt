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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import entregakotlin1.shared.generated.resources.Res
import entregakotlin1.shared.generated.resources.avatar

@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Tarjeta(
                nombre = "Elvira Ocaña Rodríguez",
                cargo = "Desarrolladora DAM",
                correo = "example@example.com",
                ciudad = "Palma"
            )
            Tarjeta(
                nombre = "Ginés Ocaña Rodríguez",
                cargo = "Desarrollador DAM",
                correo = "example2@example.com",
                ciudad = "Palma"
            )
            Tarjeta(
                nombre = "Gustavo Ocaña Rodríguez",
                cargo = "Desarrollador DAM",
                correo = "example3@example.com",
                ciudad = "Palma"
            )
        }
    }
}

@Composable
fun Tarjeta(
    nombre: String,
    cargo: String,
    correo: String,
    ciudad: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    text = cargo,
                    color = Color(0xFFC05C46)
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 8.dp)
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
