void main() {
  int maxPasajeros = 10;
  int precioPorPasajero = 120;
  int i = 1;

  print("Costos usando while:");
  while (i <= maxPasajeros) {
    print("$i pasajero(s) * \$${precioPorPasajero} = \$${i * precioPorPasajero}");
    i++;
  }

  // Reiniciar i
  i = 1;

  print("\nCostos usando do-while:");
  do {
    print("$i pasajero(s) * \$${precioPorPasajero} = \$${i * precioPorPasajero}");
    i++;
  } while (i <= maxPasajeros);
}
