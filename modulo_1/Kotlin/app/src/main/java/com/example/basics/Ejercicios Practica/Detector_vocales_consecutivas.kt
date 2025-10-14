package com.example.basics.Ejercicios

fun main() {
    print("Ingresa un texto: ")
    val texto = readln()
    val vocales = "aeiouAEIOU"
    var contador = 0

    for (i in 0 until texto.length - 1) {
        if (texto[i] in vocales && texto[i + 1] in vocales) {
            contador++
        }
    }

    println("Total de vocales consecutivas: $contador")
}


