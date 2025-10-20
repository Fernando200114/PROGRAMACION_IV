void main() {
  print(saludarPasajeros());
  print(totalAsientos(3, 4));
  print(asientosOpcionales(6, 8));
  print(asientosOpcionales(8));
  print(saludarPasajero(nombre: "Fernando", mensaje: "Bienvenido"));
}

String saludarPasajeros() => "Hola a todos los pasajeros";

int totalAsientos(int asientos1, int asientos2) => asientos1 + asientos2;

int asientosOpcionales(int asientos1, [int asientos2 = 0]) {
  return asientos1 + asientos2;
}

String saludarPasajero({required String nombre, String mensaje = "Hola"}) {
  return '$mensaje, $nombre';
}
    