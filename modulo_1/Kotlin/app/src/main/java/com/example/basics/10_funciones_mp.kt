package com.example.basics

// funcion que saluda al pasajero
fun saludarPasajero(nombre: String){
    println("Hola Bienvenido al sistema de reserva de vuelos, $nombre")
}

// funcion con parametros y retorno
fun totalPasajeros(reserva1:Int,reserva2:Int):Int{
    return reserva1 + reserva2
}

// funcion single-expression para calcular total de asientos
fun totalAsientos(asientos:Int) = asientos * asientos

// funcion con retorno multiple
fun compararReservas(reserva1: Int,reserva2:Int):Pair<Int,Int> {
    val suma = reserva1 + reserva2
    val diferencia = reserva1 - reserva2
    return Pair(suma, diferencia)
}

fun main(){
    // saludo
    saludarPasajero("Fernando")

    // total pasajeros
    val resultadoPasajeros = totalPasajeros(5,6)
    println("Total pasajeros: $resultadoPasajeros")

    // total asientos
    println("Total asientos: ${totalAsientos(5)}")

    // comparar reservas
    val resultadoComparacion = compararReservas(15,5)
    println("Suma y diferencia de reservas: $resultadoComparacion")
    //lambda
    val asientosLambda = {x: Int -> x+x}
    val saludoLambda = {nombre: String -> "Good Morning, $nombre"}

    println("Doble de asientos con lambda: ${asientosLambda(4)}")
    println(saludoLambda("Juan Luis Guerra"))
}
