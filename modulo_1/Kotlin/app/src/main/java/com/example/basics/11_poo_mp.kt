package com.example.basics

data class Pasajero(
    val nombre: String,
    val edad: Int,
    val asientoReservado: Int,
    val vip: Boolean = false

) {
    val categoria: String
        get() = when {
            vip  -> "Vip"
            asientoReservado >= 3 -> "frecuente"
            asientoReservado >= 1 -> "Regular"
            else -> {
                "Sin Reserva"
            }
        }

    fun tienebeneficios(): Boolean = vip || asientoReservado >= 3
    fun viajesolo(): Boolean = edad >= 18
    }

fun main(){
    val fernando = Pasajero("Fernando Llulluna",23,2,vip = false)

//Desentralización de un objeto

val(nombre,edad,asientoReservado)=fernando
println("Nombre  ${nombre},edad ${edad}, asiento reservado : ${asientoReservado}")

//Copiar Objetos

val Jefferson = fernando.copy(nombre="José",asientoReservado=4,vip=true)
    println(Jefferson)

//Propiedades calculada

println("Categoria de Jose ${Jefferson.categoria}")
println("AJuan tiene beneficios ${Jefferson.tienebeneficios()}")

}