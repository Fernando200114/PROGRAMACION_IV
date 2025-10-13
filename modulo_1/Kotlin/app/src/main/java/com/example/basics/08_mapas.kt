package com.example.basics

fun main(){
    println("Mapas")

    val fuerzaJedis = mapOf(
        "Luke" to 85,
        "Obi-wan" to 88,
        "Leia" to 95,
        "Yoda" to 100
    )
    println("Fuerza de los Jedis: ${fuerzaJedis}")

    println("Mapa Mutable")

    val misionesCompletadas =  mutableMapOf<String, Int>()
    misionesCompletadas ["Luke"] = 15
    misionesCompletadas ["Leia"] = 12
    misionesCompletadas.put("Han", 20)

    println("Misiones: ${misionesCompletadas}")

    for((jedi, fuerza) in fuerzaJedis){
        println("$jedi tiene nivel de fuerza $fuerza")
    }
    val planetasVisitados = setOf("Tatooine","Coruscant","Dagoboha")
    println("Planetas visitados: ${planetasVisitados}")

    val planetasPeligroso=setOf("Guayaquil","Tierra","Jupyter")
    println("Planetas Peligrosos: ${planetasPeligroso}")

    println("Operacion de conjuntos")
    val interseccion = planetasPeligroso intersect  planetasVisitados
    val union = planetasPeligroso union planetasVisitados
    val diferencia = planetasPeligroso - planetasVisitados

    println("Planetas visitados y peligrosos :${interseccion}")
    println("Todos los planetas :${union}")
    println("Planetas seguros visitados :${diferencia}")

}
