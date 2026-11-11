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

@Composable // Función que define una interfaz de usuario declarativa en Compose
fun App() {
    MaterialTheme { // Aplica el tema y estilos base de Material 3
        Column( // Contenedor vertical: apila las tarjetas una debajo de otra
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el alto y ancho disponible de la ventana
                .padding(16.dp), // Margen exterior para que las tarjetas no toquen los bordes de la ventana
            verticalArrangement = Arrangement.spacedBy(16.dp) // Separa cada tarjeta 16 dp automáticamente
        ) {
            Tarjeta( // Primera tarjeta
                nombre = "Elvira Ocaña Rodríguez",
                cargo = "Desarrolladora DAM",
                correo = "example@example.com",
                ciudad = "Palma",
                colorFondo = Color.White // Fondo blanco clásico
            )
            Tarjeta( // Segunda tarjeta: experimentamos con un fondo ligeramente diferenciado
                nombre = "Ginés Ocaña Rodríguez",
                cargo = "Desarrollador DAM",
                correo = "example2@example.com",
                ciudad = "Palma",
                colorFondo = Color(0xFFF8FAFC) // Fondo grisáceo muy suave para distinguir elementos
            )
            Tarjeta( // Tercera tarjeta
                nombre = "Gustavo Ocaña Rodríguez",
                cargo = "Desarrollador DAM",
                correo = "example3@example.com",
                ciudad = "Palma",
                colorFondo = Color.White // Fondo blanco clásico
            )
        }
    }
}

@Composable
fun Tarjeta(
    nombre: String,                   // Texto con el nombre completo de la persona
    cargo: String,                    // Puesto o titulación
    correo: String,                   // Dirección de correo electrónico
    ciudad: String,                   // Ciudad de residencia
    colorFondo: Color = Color.White,  // Color de fondo personalizable para cada elemento
    modifier: Modifier = Modifier     // Convención oficial: modificador opcional para el contenedor raíz
) {
    Card( // Tarjeta contenedora de Material 3 con esquinas redondeadas y sombra
        modifier = modifier.fillMaxWidth(), // Aplica modificadores externos y expande al ancho completo
        colors = CardDefaults.cardColors(containerColor = colorFondo), // Asigna el color de fondo personalizado
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Sombra sutil de elevación
    ) {
        Row( // Contenedor horizontal: foto a la izquierda y datos a la derecha
            modifier = Modifier.padding(16.dp), // Espaciado interior dentro de la tarjeta
            verticalAlignment = Alignment.CenterVertically, // Centra verticalmente la foto y el texto
            horizontalArrangement = Arrangement.spacedBy(16.dp) // 16 dp de separación entre foto y textos
        ) {
            Image( // Componente para pintar imágenes
                painter = painterResource(Res.drawable.playa), // Carga la imagen playa.png desde resources
                contentDescription = null, // null porque es una imagen decorativa
                contentScale = ContentScale.Crop, // Recorta rellenando el marco sin deformar
                modifier = Modifier
                    .size(80.dp) // Tamaño cuadrado de 80x80 dp
                    .clip(CircleShape) // Recorta la imagen en forma de círculo
            )

            Column( // Columna para los textos a la derecha de la foto
                modifier = Modifier.weight(1f) // Ocupa todo el espacio horizontal restante en la fila
            ) {
                Text(
                    text = nombre,
                    fontWeight = FontWeight.Bold, // Nombre destacado en negrita
                    fontSize = 18.sp, // Tamaño de fuente más grande
                    maxLines = 1, // Limita a una línea
                    overflow = TextOverflow.Ellipsis // Pone puntos suspensivos si no cabe
                )

                Text(
                    text = cargo,
                    color = Color(0xFFC05C46), // Color teja/terracota según las diapositivas
                    maxLines = 1, // Limita a una línea
                    overflow = TextOverflow.Ellipsis // Control de desbordamiento de texto
                )

                HorizontalDivider( // Línea divisoria horizontal entre el cargo y el contacto
                    modifier = Modifier.padding(vertical = 8.dp) // Margen de 8 dp arriba y abajo
                )

                Row { // Fila para alinear etiqueta y valor de correo
                    Text("Correo: ", fontWeight = FontWeight.Bold) // Etiqueta en negrita
                    Text(correo) // Correo en formato normal
                }

                Row { // Fila para alinear etiqueta y valor de ciudad
                    Text("Ciudad: ", fontWeight = FontWeight.Bold) // Etiqueta en negrita
                    Text(ciudad) // Ciudad en formato normal
                }
            }
        }
    }
}
