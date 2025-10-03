package com.example.basics

fun main(){
    println("Operadores Aritmeticos")
    val nombre1: String ="yoda"
    val nombre2: String= "yoda"
    val nombre3: String= String("yoda".toCharArray())

    println("Igualdad estructural (contenido)")
    println(nombre1==nombre2)
    println(nombre1==nombre3)
    println("Igualdad Rederencial  (misma instancia)")
    println(nombre1===nombre2)
    println(nombre1===nombre3)

}