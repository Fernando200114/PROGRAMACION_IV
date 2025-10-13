package com.example.basics

data class Jedi(
    val nombre: String,
    val edad: Int,
    val nivelFuerza: Int,
    val maestro: String?=null,
) {
    val rango: String
        get() = when {
            nivelFuerza >= 90 -> "maestro"
            nivelFuerza >= 70 -> "caballero"
            nivelFuerza >= 50 -> "padawan"
            else -> {
                "Iniciado"
            }
        }

    fun puedeEnseniar(): Boolean = nivelFuerza >= 70
    fun entrenar(): Boolean = edad <= 5
    }

fun main(){
    val luke = Jedi("Anakin Skywalter",25,75,"Obiwan Kenovi")

    println(luke)

//Desentralización de un objeto

val(nombre,edad,nivelFuerza)=luke
println("Nombre del Jedi ${nombre},edad ${edad}, nivel de fuerza : ${nivelFuerza}")

//Copiar Objetos

val ashoka = luke.copy(nombre="ashoka",nivelFuerza=80)
    println(ashoka)

//Propiedades calculada

println("Rango de ashoke ${ashoka.rango}")
println("Ashoka puede enseñar ${ashoka.puedeEnseniar()}")


}