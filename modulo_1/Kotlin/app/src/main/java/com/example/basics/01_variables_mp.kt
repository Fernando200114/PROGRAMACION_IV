package com.example.basics

fun main(){
    println("VARIABLES PARA LA RESERVA DE VUELOS")
    val aerolinea = "Aerolinea Fernando"
    var pasajero = "Fernando"

    pasajero = "Jose"

        println("Tipos de Variables")
        println("Tipos numéricos")

        println("Tipo Int")
        val edadpasajero: Int = 30
        println(edadpasajero)

        println("Tipo Double")
        val precioboleto: Double = 250.75
        println(precioboleto)

        println("Tipo Float")
        val distanciavuelo: Float = 1200f
        println(distanciavuelo)

        println("Tipo Long")
        val numerovuelo: Long = 1_234
        println(numerovuelo)

        println("Tipo Texto")
        val ciudadorigen: String = "Quito"
        val ciudaddestino: String = "Guayaquil"
        println("$ciudadorigen -> $ciudaddestino")

        println("Tipo Char")
        val clasevuelo: Char = 'E'
        println(clasevuelo)

        println("Tipo Boolean")
        val vuelodirecto: Boolean = true
        println(vuelodirecto)

        println("Nulidad")
        val asientoasignado: String? = null
        println(asientoasignado)

        println("Nulidad con longitud segura")
        val longitudasiento = asientoasignado?.length ?: 0
        println("Longitud asiento: $longitudasiento")

        println("Interpolacion de Strings")
        val mensajepasajero: String = """
        pasajero: $pasajero
        vuelo: $numerovuelo
        desde: $ciudadorigen
        hasta: $ciudaddestino
        aerolínea: $aerolinea
    """.trimIndent()
        println(mensajepasajero)

        println("Conversiones")
        val textoprecio: String = "250"
        val precioconvertido: Int = textoprecio.toInt()
        println(precioconvertido)

        val distancia: Double = 120.8
        val distanciaString: String = distancia.toString()
        println(distanciaString)
    }