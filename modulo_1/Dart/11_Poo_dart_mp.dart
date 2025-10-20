void main() {
  final Vuelo vuelo1 = Vuelo(origen: 'Madrid', destino: 'Paris', asientosDisponibles: 150);
  print(vuelo1);
  print(vuelo1.origen);
  print(vuelo1.destino);
  print(vuelo1.asientosDisponibles);
}

class Vuelo {
  String origen = "";
  String destino = "";
  int asientosDisponibles = 0;

  Vuelo({required this.origen, required this.destino, this.asientosDisponibles = 0});

  @override
  String toString() {
    return "$origen -> $destino | Asientos: $asientosDisponibles";
  }
}
