package com.example.basics


fun main(){
    println("Listas")
    val inmutableLista: List<Int> = listOf(1,2,3)
    println("Lista Inmutable ${inmutableLista}")

    val mutableLista: MutableList<Int> = mutableListOf(4,5,6)
    println("Lista Mutable ${mutableLista}")
    mutableLista.add(7)
    println("Lista Mutable ${mutableLista}")
    mutableLista.removeAt(0)
    println("Lista Mutable ${mutableLista}")

    for (mutable in mutableLista) println(mutable)

    println("Operaciones con Mutable List")

    val colores = mutableListOf("rojo", "verde")
    colores.add("azul")
    colores+="amarillo"
    colores.add(1,"blanco")
    println(colores)
    colores.remove("verde")
    println(colores)
    colores.removeAt(0)
    println(colores)
    colores[0]="negro"
    println(colores)
    colores.clear()
    println(colores.isEmpty())

    println("Busqueda con mutable List")
    val nombres = mutableListOf("juan","Luis","pedro")
    println(nombres.find{it.startsWith("l")})
    println(nombres.firstOrNull{it.length>4})
    println(nombres.any{it.contains("j")})
    println(nombres.none{it =="x"})

    println("Ordenamiento con Multiple List")
    val numerosDesordenados = mutableListOf(8,3,2,7,4,7,0,6)
    println(numerosDesordenados.sorted())
    println(numerosDesordenados.sortedDescending())
    println(numerosDesordenados.distinct())




}