void main() {
  print("Maps Iterables - Reservas de Vuelos");

  final numerosDeVuelo = [101, 102, 103, 103, 105, 105, 105, 107, 107, 108, 109, 110];
  print("Lista original de vuelos: $numerosDeVuelo");
  print("Tamaño: ${numerosDeVuelo.length}");
  print("Vuelo en índice 4: ${numerosDeVuelo[4]}");
  print("Primer vuelo: ${numerosDeVuelo.first}");

  final vuelosInvertidos = numerosDeVuelo.reversed;
  print("Vuelos invertidos (Iterable): $vuelosInvertidos");
  print("Vuelos invertidos (Lista): ${vuelosInvertidos.toList()}");
  print("Vuelos invertidos (Set): ${vuelosInvertidos.toSet()}"); // elimina duplicados
}
