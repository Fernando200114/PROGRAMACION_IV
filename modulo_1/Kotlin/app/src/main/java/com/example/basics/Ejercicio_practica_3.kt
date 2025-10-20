package com.example.basics

//Entrada: hora (0–23) y rol (“admin”, “invitado”, “empleado”).
//o Invitado solo entre 9–17 → “Permitido/Denegado”.
//o Empleado entre 6–20.
//o Admin siempre.


fun main(){
    println("Escriba la hora de entrada")
    val  hora = readln().toIntOrNull() ?: run {
        println("Por favor ingrese solo numeros")
        return
    }

    println("Ingrese el Rol (admin,invitado,empleado)")
    val rol = readln().lowercase().trim()

    val permitido = rol == "admin" ||
            (rol == "invitado" && hora in 9..17)||
            (rol == "Empleado" && hora in 6..20)
    println(if (permitido) "Permitido" else "Denegado")
}