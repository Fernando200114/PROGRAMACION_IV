package com.example.basics

enum class tipoVuelo(val categoria: String, val precioBase: Int) {
    ECONOMICO("Economico", 100) {
        override fun description() = "Vuelo basico"
    },
    BUSINESS("Business", 200) {
        override fun description() = "Vuelo medio"
    },
    VIP("VIP", 500) {
        override fun description() = "Vuelo alto"
    },
    PREMIUM("Premium", 300) {
        override fun description() = "Vuelo premium"
    };

    abstract fun description(): String

    companion object {
        fun porCategoria(categoria: String) = values().find { it.categoria == categoria }
    }
}

class Vuelo(val tipo: tipoVuelo, val pasajero: String) {
    fun activar() = "!Check-in! El vuelo ${tipo.categoria} esta asignado a $pasajero"
    fun info() = "${tipo.description()} - precio base: ${tipo.precioBase}"
}

fun main() {
    val vueloFernando = Vuelo(tipoVuelo.VIP, "Fernando Llulluna")
    println(vueloFernando)
    println(vueloFernando.activar())
    println(vueloFernando.info())
}
