package PRACTICA_EJERCICIOS

//Bucle de menú: 1) Sumar 2) Restar 3) Salir. Tras cada operación, mostrar resultado.


fun main(){
    while (true){

        println("ingrese el primer numer")
        var num = readln().toInt()
        println("ingrese el segun numer")
        var nume = readln().toInt()
        println("1, suma")
        println("2,resta")
        println("3, mul")
        println("4,div")
        println("Escoja una opcion")
        var opcion = readln().toInt()


        if (opcion == 1){
            var suma = num + nume
        println("Ha escodigo la opcion suma y el resultado es de: $suma")
        }else if (opcion == 2){
            var resta = num - num
            println("Ha escodigo la opcion suma y el resultado es de: $resta")
        }else if (opcion == 3){
            var mul = num * num
            println("Ha escodigo la opcion suma y el resultado es de: $mul")
        }else if (opcion == 4){
            var div = num / num
            println("Ha escodigo la opcion suma y el resultado es de: $div")}


    }
}