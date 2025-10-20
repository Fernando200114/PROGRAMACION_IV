package com.example.basics

//Cuenta regresiva con eventos
// Desde 30 hasta 0:
//o 20 → “Chequeo de sistemas”
//o 10 → “Últimos ajustes”
//o 0 → “Despegue”
//En los demás números solo imprime el número.

fun main(){

    for( i in 30 downTo  0)
        when (i){
            20 -> println("cheuqeo de sistemas")
            10 -> print("ultimos ajustes" )
            0 -> println("Despegue")
            else -> println(i)
        }

}