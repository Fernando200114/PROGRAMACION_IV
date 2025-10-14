package com.example.basics

class ReservaFallidaException(message: String): Exception(message)
class VueloCompletoException(message: String): Exception(message)

fun reservarVuelo(asientosDisponibles: Int, pasajerosSolicitados: Int): String {
    return try {
        when {
            asientosDisponibles <= 0 -> throw ReservaFallidaException("No hay asientos disponibles: $asientosDisponibles")
            pasajerosSolicitados > asientosDisponibles -> throw VueloCompletoException("No hay asientos para $pasajerosSolicitados pasajeros")
            else -> "Reserva exitosa para $pasajerosSolicitados pasajeros"
        }
    } catch (e: ReservaFallidaException) {
        "error: ${e.message}. elija otro vuelo"
    } catch (e: VueloCompletoException) {
        "error: ${e.message}. reduzca la cantidad de pasajeros"
    } catch (e: Exception) {
        "error : ${e.message}"
    } finally {
        "Reporte de reserva enviado"
    }
}

fun main() {
    println(reservarVuelo(asientosDisponibles = 0, pasajerosSolicitados = 1))
    println(reservarVuelo(asientosDisponibles = 5, pasajerosSolicitados = 6))
    println(reservarVuelo(asientosDisponibles = 10, pasajerosSolicitados = 3))
}
