package com.example.basics.Ejercicios

import kotlin.random.Random

fun main() {
    print("Cantidad de etapas: ")
    val etapas = readln().toInt()
    var energia = 100

    val terrenos = arrayOf("Asfalto", "Tierra", "Barro")
    val perdidas = arrayOf(5, 10, 15)

    for (i in 1..etapas) {
        val terreno = Random.nextInt(0, 3)
        energia -= perdidas[terreno]
        println("Etapa $i - Terreno: ${terrenos[terreno]} - Energia restante: $energia")

        if (energia <= 0) {
            println("Abandona en etapa $i")
            return
        }
    }

    println("Rally completado con energia $energia")
}


