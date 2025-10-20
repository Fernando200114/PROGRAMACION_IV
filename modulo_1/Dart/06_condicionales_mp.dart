void main() {
  int numeroPasajeros = 2;

  if (numeroPasajeros > 2) {
    print('Hay mas de 2 pasajeros');
  }
  if (numeroPasajeros < 2) {
    print('Hay menos de 2 pasajeros');
  }
  if (numeroPasajeros == 2) {
    print('Hay exactamente 2 pasajeros');
  } else {
    print('No hay exactamente 2 pasajeros');
  }

  int estadoReserva = 2; 

  if (estadoReserva == 1) {
    print('Reserva pendiente');
  } else if (estadoReserva == 3) {
    print('Reserva cancelada');
  } else {
    print('Reserva confirmada');
  }

  int edadPasajero = 18;
  String tipoPasajero = edadPasajero >= 18 ? 'adulto' : 'menor';
  print('Tipo de pasajero: $tipoPasajero');
}
