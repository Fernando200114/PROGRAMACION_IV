package PRACTICA_EJERCICIOS

//Semáforo peatonal
//Pide color del semáforo ("rojo", "amarillo", "verde") y si el peatón presionó el botón ("si"/"no").
//Si está verde y presionó → “Espera a rojo”.
//Si está rojo → “Cruza”.
//Si amarillo → “Prepárate”.
//En otros casos → “Espera”.

fun main(){

    println("hola por favor ingrese un color verde,amarillo,rojo")
    var color = readln().lowercase()
    println("presione el voton si/no")
    var boton = readln().lowercase()

    if(color == "verde" && boton =="si"){
        println("Cruza")
    }else if (color == "rojo" && boton == "no"){
        println("Espera el rojo")
    }else if (color == "amarillo" && boton == "si"){
        println("Preparate")
    }else {
        print("Espera")
    }

}