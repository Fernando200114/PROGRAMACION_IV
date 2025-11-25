package PRACTICA_EJERCICIOS

//Entrada de cine con descuento por edad
//Pide edad. Base $5.
//
//<12 → $3
//≥65 → $4
//Si no, $5.

fun main(){
    println("Ingrese un numero ")
    var edad = readln().lowercase().toInt()
    if(edad == null || edad <= 5 ) {
        println("Vuelva ingresar el numero su base es de 5")
    }else {

        when {
            edad < 12 -> println("es 3")

                edad >= 65 -> println("es 4")
        else ->
                println("No es 5")

        }
    }
}