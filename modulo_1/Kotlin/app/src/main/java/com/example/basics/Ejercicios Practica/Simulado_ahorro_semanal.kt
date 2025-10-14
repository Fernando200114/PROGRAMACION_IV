fun main() {
    print("meta de ahorro: ")
    val meta = readln().toDoubleOrNull()
    if (meta == null || meta <= 0) {
        println("meta invalida")
        return
    }

    print("ahorro inicial: ")
    var ahorro = readln().toDoubleOrNull()
    if (ahorro == null || ahorro < 0) {
        println("ahorro inicial invalido")
        return
    }

    var semana = 1
    var deposito = 5.0

    while (ahorro < meta) {
        println("semana $semana: ahorro = $ahorro")
        ahorro += deposito
        deposito += 10
        semana++
    }

    println("meta alcanzada en la semana $semana con ahorro $ahorro")
}
