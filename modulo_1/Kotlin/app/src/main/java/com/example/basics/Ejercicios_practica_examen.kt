package com.example.basics

//1. Termostato doméstico
//Pide temperatura actual (°C) y preferencia del usuario: “frío”, “templado” o
//“caliente”.
//o Si pref. = “frío” y temp > 22 → “Encender aire”
//o Si pref. = “caliente” y temp < 18 → “Encender calefacción”
//o Si pref. = “templado” y 18–22 → “En confort”
//o En otros casos → “Ventilar”


fun main(){
    println("Hola ayudame ingresando la temperatura actual en (C")

    val temp = readln().toDoubleOrNull() ?: run {
        println("Datos ingresados incorrectos")
        return
    }



    println ("Ingrese su preferencia(frio,templado o caliente)")
    val pref = readln().trim().lowercase()

    val resultado = when (pref){
        "frio" -> if (temp > 22 )"Encender el aire" else "ventilar"
        "caliente" -> if (temp < 18)"Encender la calefaccion " else "VEntilar"
        "templado" -> if (temp in 18.00..22.00)"En confort" else "Ventilar"
        else -> "Preferencia invalida"

    }
        println("El resultado es : $resultado")
}