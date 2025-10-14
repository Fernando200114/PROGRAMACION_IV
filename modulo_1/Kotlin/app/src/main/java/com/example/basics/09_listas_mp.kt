package com.example.basics


fun main(){
    println("Listas")
    val inmutableVuelo: List<String> = listOf("Vuelo1","Vuelo2","Vuelo3")
    println("Vuelos Diponibles ${inmutableVuelo}")

    val vuelosDisponibles: MutableList<String> = mutableListOf("Vuelo4","Vuelo5","vuelo6")
    println("Vuelos Disponibles ${vuelosDisponibles}")
    vuelosDisponibles.add("Vuelo7")
    println("Vuelos Diponibles ${vuelosDisponibles}")
    vuelosDisponibles.removeAt(0)
    println("Vuelos Diponibles ${vuelosDisponibles}")

    for (vuelo in vuelosDisponibles) println(vuelo)

    println("Operaciones con Mutable List")

    val pasajeros = mutableListOf("Fernando", "José")
    pasajeros.add("Llulluna")
    pasajeros += "Cuichan"
    pasajeros.add(1,"Carlos")
    println("Lista de pasajeros: $pasajeros")
    pasajeros.remove("Fernando")
    println("Después de eliminar a Fernando: $pasajeros")
    pasajeros.removeAt(0)
    println("Despues de eliminar el primer pasajero: $pasajeros")
    pasajeros[0] = "Jefferson Rene"
    println("Despues de actualizar el primer pasajero: $pasajeros")

    pasajeros.clear()
    println("Lista de pasajeros vacía ${pasajeros.isEmpty()}")


    println("Busqueda con mutable List")
    val nombreReserva = mutableListOf("Fernando","José","Llulluna","Cuichan")
    println(nombreReserva.find{it.startsWith("l")})
    println(nombreReserva.firstOrNull{it.length>4})
    println(nombreReserva.any{it.contains("j")})
    println(nombreReserva.none{it =="x"})

    println("Ordenamiento con Multable  List")
    val numerosAsientos = mutableListOf(8,3,2,7,4,7,0,6)
    println("Asientos ordenados Ascendente :${numerosAsientos.sorted()}")
    println("Asientos ordenados descendente :${numerosAsientos.sortedDescending()}")
    println("Asientos sin duplicados :${numerosAsientos.distinct()}")




}