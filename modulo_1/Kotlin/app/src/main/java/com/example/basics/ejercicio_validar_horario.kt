package com.example.basics

fun main() {
    println("Ingrese una hora (0/23)")

    val mañana = readLine()!!.toDouble()

    println("Ingrese una hora (14/19)")
    val tarde = readLine()!!.toDouble()

    println("Resultado")

    if (mañana >= 7.0 && mañana <= 13.0) {
        println("Tiene clase en la mañana")
    } else {
        println("No tiene clase en la mañana")
    }

    if (tarde >= 14.0 && tarde <= 19.0) {
        println("Tiene clase en la tarde")
    } else {
        println("No tiene clase en la tarde")
    }
}
