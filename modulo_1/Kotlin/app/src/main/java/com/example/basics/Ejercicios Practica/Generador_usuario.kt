package com.example.basics.Ejercicios



fun main() {
    println("Ingrese su nombre:")
    val nombre = readln()

    println("Ingrese su apellido:")
    val apellido = readln()

    var username = ""
    var i = 0
    while (i < nombre.length || i < apellido.length) {
        if (i * 2 < nombre.length) {
            username += nombre.substring(i * 2, (i * 2 + 2).coerceAtMost(nombre.length))
        }
        if (i * 2 < apellido.length) {
            username += apellido.substring(i * 2, (i * 2 + 2).coerceAtMost(apellido.length))
        }
        i++
    }

    var num = 1
    while (username.length < 6) {
        username += num
        num++
    }

    println("Username generado: $username")
}

