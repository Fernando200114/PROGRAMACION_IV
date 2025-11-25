void main() {
  int n = 10;
  int tabla = 3;
  int i = 0;

  // Bucle while
  while (i < n) {
    print("$i * $tabla = ${i * tabla}");
    i++;
  }

  // Reiniciamos i para el segundo bucle
  i = 1;

  // Bucle do-while
  do {
    print("$i * $tabla = ${i * tabla}");
    i++;
  } while (i < n);
}