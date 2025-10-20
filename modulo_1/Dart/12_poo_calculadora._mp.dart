void main() {
  final Calc calc = Calc(distancia: 700, velocidad: 350);
  print(calc.tiempo());
  print(calc.costo());
  print(calc.combustible());
  print(calc.velocidad);
}

class Calc {
  double distancia = 0;
  double velocidad = 0;

  Calc({required this.distancia, required this.velocidad});

  double tiempo() {
    return distancia / velocidad;
  }

  double costo() {
    return tiempo() * 100;
  }

  double combustible() {
    return distancia * 5;
  }
}
