package com.example.entregakotlin1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform