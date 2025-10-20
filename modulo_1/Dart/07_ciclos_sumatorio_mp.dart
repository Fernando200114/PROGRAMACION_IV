void main() {
  int cantidadPasajeros = 10;
  double precioPorPasajero = 100.0;
  double total = 0;

  for (int i = 1; i <= cantidadPasajeros; i++) {
    total += precioPorPasajero;
  }

  print("El costo total para $cantidadPasajeros pasajeros es \$${total}");
}
