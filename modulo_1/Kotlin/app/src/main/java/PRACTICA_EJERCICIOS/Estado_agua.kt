//Estado del agua por temperatura
//Pide °C.

//≤0 → “Sólido”

//1..99 → “Líquido”

//≥100 → “Gas”


fun main(){
    println("ingresa la temperatura")
    val temperatura = readln().toInt()

    when {
        temperatura <= 0 -> println("solido")
        temperatura in 1..99 -> println("Liquio")
        temperatura >= 100 -> println("gas")
    }
}
