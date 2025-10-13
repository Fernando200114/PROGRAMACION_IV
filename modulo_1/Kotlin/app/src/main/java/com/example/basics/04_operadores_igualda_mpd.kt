package com.example.basics

fun main() {
    println("operadores de igualdad - vuelos")

    val pasajero1: String = "fernando"
    val pasajero2: String = "fernando"
    val pasajero3: String = String("fernando".toCharArray())

    println("igualdad estructural (contenido)")
    println(pasajero1 == pasajero2)
    println(pasajero1 == pasajero3)

    println("igualdad referencial (misma instancia)")
    println(pasajero1 === pasajero2)
    println(pasajero1 === pasajero3)
}