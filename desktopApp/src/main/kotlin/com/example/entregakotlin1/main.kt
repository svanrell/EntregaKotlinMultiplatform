package com.example.entregakotlin1

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Tarjeta de presentación",
        state = rememberWindowState(width = 850.dp, height = 650.dp)
    ) {
        App()
    }
}
