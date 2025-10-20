package com.example.basics

//Cola de supermercado
//En un while pide “nuevo cliente (total) o fin”. Si total > 100 aplica 5% desc.; si
//lleva más de 10 ítems, mensaje “Caja rápida no disponible”. Acumula venta del
//día y al final muestra total y cantidad de clientes.



fun main() {

    var totalVentas = 0.0
    var cantidadClientes = 0

    while (true) {
        println("Ingrese el total del cliente o 'fin' para terminar:")

        val entrada = readln()
        if (entrada.lowercase() == "fin") break

        val totalCliente = entrada.toDoubleOrNull()
        if (totalCliente == null || totalCliente < 0) {
            println("Número ingresado no válido. Intente de nuevo.")
            continue
        }

        println("Ingrese la cantidad de ítems del cliente:")
        val items = readln().toIntOrNull()
        if (items == null || items < 0) {
            println("Número de ítems incorrecto. Debe ser mayor o igual a cero.")
            continue
        }

        var precioFinal = totalCliente

        // Aplica 5% de descuento si total > 100
        if (totalCliente > 100) {
            precioFinal *= 0.95
        }

        // Si hay más de 10 ítems
        if (items > 10) {
            println("Caja rápida no disponible.")
        }

        totalVentas += precioFinal
        cantidadClientes++
    }

    println("Total del día: $totalVentas")
    println("Cantidad de clientes: $cantidadClientes")
}
