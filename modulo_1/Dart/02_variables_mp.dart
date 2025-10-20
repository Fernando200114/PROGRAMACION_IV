void main() {
  print("Tipos de Variables en Dart");
  
  final String pasajero = "Fernando LLulluna";
  print(pasajero);
  
  String nombre = "Fernando";
  nombre = "Llulluna";
  print(nombre);
  
  const String clase = "Economica";
  print("Clase:$clase");
  
  bool active = false;
  active = false;
  
  print("La reserva se encuentra  :$active");
  
  int numero_de_vuelo = 10;
  print("el numero de vuelo es  $numero_de_vuelo");
  
  List<String> servicios = ["celular","Zapatos"];
  print("Servicios $servicios");
  
 final imagenes = <String>["src/avion1.jpg", "src/asiento1.jpg"];
  print("Imágenes: $imagenes");
  
  print("Impresion en variias lineas");
  print("""
  $pasajero
  $numero_de_vuelo
  $imagenes
  $servicios
  """);
  
  }