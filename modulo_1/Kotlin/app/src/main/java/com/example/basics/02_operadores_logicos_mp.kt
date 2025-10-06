package com.example.basics


fun main() {
    println("operadores logicos reserva de vuelos")

    val edadpasajero: Int = 25
    val tienepasaporte: Boolean = true
    val equipajeligero: Boolean = true

    val puedeabordar = edadpasajero >= 18 && tienepasaporte && equipajeligero
    val necesitaasistencia = !tienepasaporte || !equipajeligero

    println("puede abordar: $puedeabordar")
    println("necesita asistencia: $necesitaasistencia")
}
