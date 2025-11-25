package com.example.basics.Ejercicios

//downTo -> Crea un rango decreciente

fun main() {
    for (i in 30 downTo 0) {
        when (i) {
            20 -> println("chequeo de sistemas")
            10 -> println("ultimos ajustes")
            0 -> println("despegue")
            else -> println(i)
        }
    }
}


