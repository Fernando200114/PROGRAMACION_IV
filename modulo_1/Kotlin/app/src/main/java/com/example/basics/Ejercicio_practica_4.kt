package com.example.basics

//Simulador de ahorro semanal
//Entrada: meta y ahorro inicial. Cada semana sumas +10 a la cantidad semanal
//que depositas (empieza en 5). Imprime semana a semana hasta alcanzar meta.

fun main(){
    println("Simulador de Ahorro Semanal")
    println("Ingrese la meta del ahorro :")
    val meta = readln().toDoubleOrNull() ?: run {
        print("Ingrese solo valores numericos")
        return
    }
    println("Ingrese el ahorro ingresado")
    var ahorro = readln().toDoubleOrNull() ?: run{
        println("Ingrese solo valores numericos")
        return

    }
    var semana1 = 1
    var empieza = 5.0

    while (ahorro < meta){
       ahorro += empieza
        println("La semana $semana1 depostitas : $empieza -> tienes un total de $ahorro")

        empieza += 10
        semana1 ++
        println("--------------------------------")
        println("¡Meta alcanzada! Ahorro final: $ahorro")

    }

}