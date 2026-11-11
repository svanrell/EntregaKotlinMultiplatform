package com.example.entregakotlin1

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

// -----------------------------------------------------------------------------------------
// PUNTO DE ENTRADA DE LA APLICACIÓN DE ESCRITORIO
// application {...} gestiona el ciclo de vida de la aplicación Compose Desktop.
// Window {...} crea la ventana del sistema operativo con el título y dimensiones indicadas.
// -----------------------------------------------------------------------------------------
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication, // Cierra la app al pulsar el botón de cerrar ventana
        title = "Tarjeta de presentación", // Título exacto solicitado en el ejercicio
        state = rememberWindowState(width = 850.dp, height = 650.dp) // Dimensiones iniciales de la ventana
    ) {
        App() // Llamada al composable principal de la interfaz
    }
}
