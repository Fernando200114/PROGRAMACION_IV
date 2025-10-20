package com.example.basics

//Entrada: distancia (km) y si llueve (sí/no).
//o Si distancia ≤ 5 → base 2.5
//o Si 6–15 → base 5
//o Si > 15 → base 8
//o Si llueve, sumar 1.5.
//Imprimir “Costo total: …”.


fun main(){
     println("Hola ingrese la distancia deseada ")
    val distancia = readln().toDoubleOrNull() ?: run{
        println("Por favor ingrese valores numericos ")
        return

    }
    if (distancia < 0) {
        println("La distancia no puede ser negativa")
        return
    }
        println("Esta lloviendo? si/no")
    val lluvia = readln().lowercase().trim()


    val base = when {
        distancia <= 5 -> 2.5
        distancia in 6.0..15.0 -> 5.0
        distancia > 15 -> 8.0
        else -> {
            println("Distancia invalida")
            return

        }
    }

    val llueve = if (lluvia == "sí" || lluvia == "si")1.5 else 0.0

    val total = base + llueve

    println("Recargo por lluvia si llueve es de: $total")

}