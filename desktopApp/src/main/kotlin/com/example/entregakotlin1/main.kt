package com.example.entregakotlin1

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application { // Arranca el ciclo de vida de la aplicación Compose Desktop
    Window(
        onCloseRequest = ::exitApplication, // Cierra la app al pulsar la cruz de la ventana
        title = "Tarjeta de presentación", // Título de la ventana según el ejercicio
        state = rememberWindowState(width = 850.dp, height = 650.dp) // Dimensiones iniciales de la ventana
    ) {
        App() // Llama a la interfaz principal definida en App.kt
    }
}
