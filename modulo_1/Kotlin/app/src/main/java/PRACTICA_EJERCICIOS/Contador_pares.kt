package PRACTICA_EJERCICIOS
//
//Contador de pares hasta N
//Pide N y cuenta cuántos números pares hay entre 1 y N.

fun main(){
    var contador = 0

    println("Ingresa un numero")
    var n  = readln().lowercase().toInt()


    for (i in 1..n){
        if(i %2 ==0)
            contador +=1

    }
    println("Hay  $contador : numeros pares")
}