package com.example.basics

fun main(){
    println("Reserva de  Vuelos")

    val VuelosDiposnibles = mapOf(
        "Vuelo1" to 85,
        "Vuelo2" to 88,
        "Vuelo3" to 95,
        "Vuelo4" to 100
    )
    println("Vuelos disponibles : ${VuelosDiposnibles}")

    println("Mapa Mutable")

    val ReservasConfirmadas =  mutableMapOf<String, Int>()
    ReservasConfirmadas ["Fernando"] = 15
    ReservasConfirmadas ["José"] = 12
    ReservasConfirmadas.put("Llulluna cuichan", 20)

    println("Reservas Confirmadas: ${ReservasConfirmadas}")

    for((vuelos, cupos) in VuelosDiposnibles){
        println("$vuelos tiene$cupos asientos disponibles")
    }
    val destinosPopulares = setOf("Quito","Guayaquil","Cuenca")
    println("Destinos Populares : ${destinosPopulares}")

    val destinosPeligroso=setOf("Guayaquil","Guayaquil2","Guayaquil3")
    println("Destinos mas Peligrosos: $destinosPeligroso")

    println("Operacion de conjuntos")
    val interseccion = destinosPopulares intersect destinosPeligroso
    val union = destinosPopulares union destinosPeligroso
    val diferencia = destinosPopulares - destinosPeligroso

    println("Destinos visitados y peligrosos :${interseccion}")
    println("Todos los destinos :${union}")
    println("Destinos seguros visitados :${diferencia}")

}
