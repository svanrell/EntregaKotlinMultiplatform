package com.example.entregakotlin1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

// Recursos generados para imágenes
import entregakotlin1.shared.generated.resources.Res
import entregakotlin1.shared.generated.resources.avatar

/**
 * Modelo de datos para representar la información de cada tarjeta de presentación.
 * Permite personalizar los datos y los estilos visuales (color de fondo, borde) por elemento.
 */
data class TarjetaInfo(
    val nombre: String,
    val cargo: String,
    val correo: String,
    val ciudad: String,
    val colorFondo: Color = Color.White,
    val colorBorde: Color = Color(0xFFE2E8F0)
)

// Paleta de colores fieles a la captura y los apuntes
val ColorFondoVentana = Color(0xFFF1F5F9)
val ColorTextoPrincipal = Color(0xFF1E293B)
val ColorCargoTerracota = Color(0xFFC05C46)
val ColorTextoSecundario = Color(0xFF475569)
val ColorSeparador = Color(0xFFE2E8F0)

@Composable
fun App() {
    MaterialTheme {
        // Colección de datos para las 3 tarjetas requeridas en el ejercicio
        val tarjetas = listOf(
            TarjetaInfo(
                nombre = "Elvira Ocaña Rodríguez",
                cargo = "Desarrolladora DAM",
                correo = "example@example.com",
                ciudad = "Palma",
                colorFondo = Color(0xFFFFFFFF),
                colorBorde = Color(0xFFE2E8F0)
            ),
            TarjetaInfo(
                nombre = "Ginés Ocaña Rodríguez",
                cargo = "Desarrollador DAM",
                correo = "example2@example.com",
                ciudad = "Palma",
                colorFondo = Color(0xFFFAFAFA),
                colorBorde = Color(0xFFCBD5E1)
            ),
            TarjetaInfo(
                nombre = "Gustavo Ocaña Rodríguez",
                cargo = "Desarrollador DAM",
                correo = "example3@example.com",
                ciudad = "Palma",
                colorFondo = Color(0xFFFFFFFF),
                colorBorde = Color(0xFFE2E8F0)
            )
        )

        // Contenedor principal: distribuye las tarjetas verticalmente con scroll
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ColorFondoVentana)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            tarjetas.forEach { tarjeta ->
                TarjetaPresentacion(
                    nombre = tarjeta.nombre,
                    cargo = tarjeta.cargo,
                    correo = tarjeta.correo,
                    ciudad = tarjeta.ciudad,
                    colorFondo = tarjeta.colorFondo,
                    colorBorde = tarjeta.colorBorde
                )
            }
        }
    }
}

/**
 * Componente reutilizable para mostrar un par "Etiqueta: Valor" con formatos tipográficos distintos.
 * Cumple con la convención oficial de Compose recibiendo modifier como parámetro opcional.
 */
@Composable
fun DatoContacto(
    etiqueta: String,
    valor: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = etiqueta,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = ColorTextoPrincipal,
            maxLines = 1
        )
        Text(
            text = valor,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = ColorTextoSecundario,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

/**
 * Componente modular principal para cada Tarjeta de Presentación.
 * Recibe los datos y modificadores, combinando Card, Row, Column, Image, HorizontalDivider y Text.
 */
@Composable
fun TarjetaPresentacion(
    nombre: String,
    cargo: String,
    correo: String,
    ciudad: String,
    colorFondo: Color = Color.White,
    colorBorde: Color = Color(0xFFE2E8F0),
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { println("Tarjeta seleccionada: $nombre") },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorFondo
        ),
        border = BorderStroke(1.dp, colorBorde),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Imagen de perfil circular con ContentScale.Crop y borde sutil
            Image(
                painter = painterResource(Res.drawable.avatar),
                contentDescription = "Fotografía de $nombre",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color(0xFFCBD5E1), CircleShape)
            )

            // Columna con los textos en distintos formatos
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // 1. Nombre en negrita destacado
                Text(
                    text = nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = ColorTextoPrincipal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // 2. Cargo con color terracota diferenciado
                Text(
                    text = cargo,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = ColorCargoTerracota,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // 3. Línea divisoria horizontal
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    thickness = 1.dp,
                    color = ColorSeparador
                )

                // 4. Correo electrónico (etiqueta negrita + valor regular)
                DatoContacto(
                    etiqueta = "Correo: ",
                    valor = correo
                )

                Spacer(modifier = Modifier.height(2.dp))

                // 5. Ciudad (etiqueta negrita + valor regular)
                DatoContacto(
                    etiqueta = "Ciudad: ",
                    valor = ciudad
                )
            }
        }
    }
}
