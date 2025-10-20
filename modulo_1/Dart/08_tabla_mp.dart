void main() {
  int maxPasajeros = 10;
  int precioPorPasajero = 120;

  print("Tabla de costos para $precioPorPasajero por pasajero:");

  for (int i = 1; i <= maxPasajeros; i++) {
    print("$i pasajero(s) * $precioPorPasajero = \$${i * precioPorPasajero}");
  }
}
