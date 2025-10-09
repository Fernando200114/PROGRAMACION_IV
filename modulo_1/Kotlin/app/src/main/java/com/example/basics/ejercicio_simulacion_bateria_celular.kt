package com.example.basics

fun main() {
    for (bateria in 0..100 step 10) {
        when {
            bateria == 100 -> println("Bateria llena")
            bateria <= 10 -> println("Conecte el cargador")
            bateria <= 50 -> println("Mitad de bateria")
            else -> println("Bateria suficiente")
        }

    }
}
