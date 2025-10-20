package com.example.basics.Ejercicios


fun main() {
    print("Hola este es el costo de envio express ingrese la distancia en km ")
    val distancia = readln().toIntOrNull()

    if (distancia == null || distancia < 0) {
        println("Distancia no permitida")
        return
    }

    print("Esta lloviendo (sí/no): ")
    val lluvia = readln().trim().lowercase()

    val base = when (distancia) {
        in 0..5 -> 2.5
        in 6..15 -> 5.0
        else -> 8.0
    }

    val extraLluvia = if (lluvia == "sí" || lluvia == "si") 1.5 else 0.0

    val total = base + extraLluvia

    println("Costo total: $total")
}

