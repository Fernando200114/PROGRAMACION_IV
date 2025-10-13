package com.example.basics

fun main() {
    try {
        val pasajeros = 10
        val vuelos = 0
        val promedio = pasajeros / vuelos
    } catch (e: Exception) {
        println(e)
        println("No se puede calcular el promedio")
    }
}
