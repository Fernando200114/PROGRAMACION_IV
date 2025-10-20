package com.example.basics

//Detector de vocales consecutivas
//Pide un texto y recórrelo. Cuenta cuántas veces aparecen dos vocales seguidas
//(aeiou/AEIOU). Imprime el total.

fun main() {

    println("Por favor ingrese un texto de prueba")
    val texto = readln()
    val vocales = ("aeiouAEIOU")
    var contador = 0

    for (i in 0 until texto.length - 1)
        if (texto[ i ] in vocales && texto [i+1] in vocales){
        contador++
    }
    println("Total de vocales consecutivas: $contador")
}