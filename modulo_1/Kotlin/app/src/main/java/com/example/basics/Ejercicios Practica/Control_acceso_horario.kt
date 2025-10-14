package com.example.basics.Ejercicios

fun main() {
    print("Hola por favor ingrese el horario (0-23)")
    val hora = readln().toIntOrNull() ?: run {
        println("Hora no permitida")
        return
    }

    print("Ingrese rol (admin, invitado, empleado): ")
    val rol = readln().trim().lowercase()

    val permitido = rol == "admin" ||
            (rol == "invitado" && hora in 9..17) ||
            (rol == "empleado" && hora in 6..20)

    println(if (permitido) "Permitido" else "Denegado")
}
