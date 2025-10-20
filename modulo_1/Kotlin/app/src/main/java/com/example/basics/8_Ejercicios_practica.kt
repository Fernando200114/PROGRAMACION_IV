package com.example.basics

//ATM simplificado
//Saldo inicial. En bucle muestra menú: 1) Depositar 2) Retirar 3) Salir.
//o Retiro no puede dejar saldo negativo.
//o Cada operación imprime saldo actual.
//Finaliza con “Sesión terminada”.


fun main(){

    var saldo_inicial = 1000.00

    while (true){
        println("Hola este es el menu que se debe de ingresar jaja")
        println("Seleccione las siguientes opciones")
        println("1.Depositar")
        println("2.Retirar")
        print("3.Salir")

        val opcion = readln().lowercase().trim()

        when(opcion) {
            "1" -> {
                val deposito = readln().toDoubleOrNull()
                if (deposito == null || deposito < 0) {
                    println("Por favor ingrese numeros positivos")
                } else {
                    saldo_inicial += deposito
                    println("Saldo ingresado correctamente saldo actual es de $saldo_inicial")
                }
            }

            "2" -> {
                val retiro = readln().toIntOrNull()
                if (retiro == null || retiro <= 0) {
                    println("Monto invalido intentelo nuevamente")
                } else if (retiro > saldo_inicial) {
                    println("Su Saldo ha sido insuficnete $saldo_inicial")
                } else {
                    saldo_inicial -= retiro
                    println("Su retiro se ha realizado con exito $saldo_inicial")
                }
            }

            "3" -> {
                println("Ha precionado la opcion de salir gracoas vurlva pronto")
                break
            }

            else -> {
                println("opcion no valida intentelo de nuevo ")
            }

        }}}



