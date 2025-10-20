package com.example.basics.Ejercicios

fun main() {
    print("Hola este es su sistema de termostatico Por favor ingrese la temperatura actual ")
    val temp = readln().toDoubleOrNull() ?: run {
        println("Temperatura inválida")
        return
    }

    print("Ingrese su preferencia (frio, templado o caliente)")
    val pref = readln().trim().lowercase()

    val resultado = when (pref) {
        "frio" -> if (temp > 22) "Encender el aire" else "Ventilar"
        "caliente" -> if (temp < 18) "Encienda Calefaccion" else "Ventilar"
        "templado" -> if (temp in 18.0..22.0) "En confort" else "Ventilar"
        else -> "Preferencia invalida"
    }

    println("Resultado: $resultado")
}

