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

// Importamos el acceso a la imagen 'avatar.png' generada por Compose Resources
import entregakotlin1.shared.generated.resources.Res
import entregakotlin1.shared.generated.resources.avatar

// -----------------------------------------------------------------------------------------
// COMPOSABLE PRINCIPAL: App
// La anotación @Composable le indica a Kotlin que esta función define una interfaz gráfica declarativa.
// -----------------------------------------------------------------------------------------
@Composable
fun App() {
    // MaterialTheme aplica el sistema de diseño Material 3 (colores y tipografías por defecto)
    MaterialTheme {
        // Column apila los elementos verticalmente (uno debajo de otro).
        // - fillMaxSize(): hace que ocupe todo el ancho y alto disponible de la ventana.
        // - padding(16.dp): margen interior para que las tarjetas no se peguen a los bordes de la ventana.
        // - Arrangement.spacedBy(16.dp): separa automáticamente cada tarjeta 16 dp en vertical.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Reutilizamos el Composable 'Tarjeta' llamándolo 3 veces con parámetros con nombre.
            // Esto evita duplicar código y hace que la estructura sea limpia y legible.
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

// -----------------------------------------------------------------------------------------
// COMPOSABLE REUTILIZABLE: Tarjeta
// Recibe como argumentos los datos específicos de cada persona para pintar la tarjeta.
// -----------------------------------------------------------------------------------------
@Composable
fun Tarjeta(
    nombre: String,
    cargo: String,
    correo: String,
    ciudad: String
) {
    // Card: componente de Material 3 que crea un contenedor con bordes redondeados y sombra
    Card(
        modifier = Modifier.fillMaxWidth(), // La tarjeta se expande a todo el ancho
        colors = CardDefaults.cardColors(containerColor = Color.White), // Fondo blanco limpio
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Sombra sutil de elevación
    ) {
        // Row: coloca sus elementos hijos horizontalmente (uno al lado de otro).
        // - verticalAlignment = CenterVertically: alinea la foto y los textos en el centro vertical.
        // - spacedBy(16.dp): deja 16 dp de espacio entre la imagen y el bloque de texto.
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. IMAGEN DE PERFIL
            // - painterResource: carga la imagen desde resources/drawable/avatar.png
            // - contentScale = ContentScale.Crop: escala la imagen rellenando sin deformarse
            // - clip(CircleShape): recorta la imagen en círculo perfecto
            Image(
                painter = painterResource(Res.drawable.avatar),
                contentDescription = null, // null porque es decorativa
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            // 2. BLOQUE DE TEXTOS
            // - weight(1f): modificador clave en una Row; hace que esta columna consuma
            //   todo el espacio horizontal restante a la derecha de la imagen.
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Nombre: destacado en negrita y tamaño mayor (18.sp)
                Text(
                    text = nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                // Cargo: texto en color teja/terracota según el diseño de clase
                Text(
                    text = cargo,
                    color = Color(0xFFC05C46)
                )

                // Línea separadora horizontal con 8 dp de margen vertical arriba y abajo
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Fila de Correo: etiqueta "Correo: " en negrita y dirección normal
                Row {
                    Text("Correo: ", fontWeight = FontWeight.Bold)
                    Text(correo)
                }

                // Fila de Ciudad: etiqueta "Ciudad: " en negrita y nombre de ciudad normal
                Row {
                    Text("Ciudad: ", fontWeight = FontWeight.Bold)
                    Text(ciudad)
                }
            }
        }
    }
}
