package com.example.basics

//El usuario ingresa su promedio y si trabaja (si o no)
//Premedio >= 90 y No trabaja -> Beca completa
//Premedio >= 90 trabaja -> beca parcial
//Premedio >= 90 -> Sin Beca

fun main(){
        println("Ejercicio Sistema de Becas")
        println("Ingrese su promedio")
        val promedio = readLine()!!.toDouble()

                println("Ingrese si trabaja (Si/No)")
                val trabaja = readLine()!!.lowercase()

        println("Resultado")

        if(promedio >= 90 && trabaja == "no")
                println("Tiene una beca completa")
        if(promedio >= 90 && trabaja == "si")
                println("Tiene beca parcial")
        else
                println("Sin Beca")
}


