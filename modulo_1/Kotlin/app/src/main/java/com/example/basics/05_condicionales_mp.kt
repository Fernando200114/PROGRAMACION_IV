fun main() {
    println("estructuras de control")
    println("condicionales")

    val edadpasajero = 25
    val edadminima = 18

    if (edadpasajero > edadminima) {
        println("puede abordar")
    } else {
        println("no puede abordar")
    }

    println("categoria segun equipaje")
    val pesoequipaje = 20 // en kg

    if (pesoequipaje > 23) {
        println("sobrepeso")
    } else if (pesoequipaje > 15) {
        println("equipaje aceptable")
    } else {
        println("equipaje ligero")
    }
}