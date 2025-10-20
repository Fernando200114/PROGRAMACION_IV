void main() {
  print("Maps - Sistema de Reserva de Vuelos");
  
  final Map<String, dynamic> reservaVuelo = {
    'pasajero': 'Fernando Llulluna',
    'numeroVuelo': 100,
    'reservaActiva': true,
    'servicios': <String>['Equipaje extra', 'Comida vegetariana'],
    'imagenes': {
      1: 'src/avion1.jpg',
      2: 'src/asiento1.jpg',
    }
  };

  print(reservaVuelo);
  print(reservaVuelo['pasajero']);
  print(reservaVuelo['imagenes']);
  print(reservaVuelo['reservaActiva']);
}
