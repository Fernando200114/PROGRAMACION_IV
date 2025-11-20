import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class NuevobotonPages extends StatefulWidget {
  const NuevobotonPages({super.key});

  @override
  State<NuevobotonPages> createState() => _NuevobotonPagesState();
}

class _NuevobotonPagesState extends State<NuevobotonPages> {
  String precio = '';
  String cantidad = '';
  String tipo_clientes = 'Nuevo';
  String resultado = '';

  void calcularTotal() {
    final precioNum = double.tryParse(precio) ?? 0;
    final cantidadNum = int.tryParse(cantidad) ?? 0;

    if (precioNum <= 0 || cantidadNum <= 0) {
      setState(() {
        resultado = 'Ingrese valores válidos para precio y cantidad';
      });
      return;
    }

  
    double descuentoPorcentaje = 0;

    if (tipo_clientes == 'Nuevo') {
      descuentoPorcentaje = 0;
    } else if (tipo_clientes == 'Frecuente') {
      descuentoPorcentaje = 8;
    } else if (tipo_clientes == 'Corporativo') {
      descuentoPorcentaje = 12;
    }

    final subtotal = precioNum * cantidadNum;
    final valorDescuento = subtotal * (descuentoPorcentaje / 100);
    final totalFinal = subtotal - valorDescuento;

    setState(() {
      resultado =
          'Subtotal: \$${subtotal.toStringAsFixed(2)}\n'
          'Descuento: $descuentoPorcentaje%\n'
          'Monto de descuento: \$${valorDescuento.toStringAsFixed(2)}\n'
          'Total a pagar: \$${totalFinal.toStringAsFixed(2)}';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Calcular costo del menú'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              decoration: const InputDecoration(
                labelText: 'Precio base del menú',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (v) => precio = v,
            ),

            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Cantidad de menús',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (v) => cantidad = v,
            ),

            const SizedBox(height: 16),

            DropdownButtonFormField(
              value: tipo_clientes,
              decoration: const InputDecoration(
                labelText: 'Tipo de cliente',
                border: OutlineInputBorder(),
              ),
              items: const [
                DropdownMenuItem(value: 'Nuevo', child: Text('Nuevo (0%)')),
                DropdownMenuItem(value: 'Frecuente', child: Text('Frecuente (8%)')),
                DropdownMenuItem(value: 'Corporativo', child: Text('Corporativo (12%)')),
              ],
              onChanged: (value) {
                tipo_clientes = value.toString();
              },
            ),

            const SizedBox(height: 20),

            ElevatedButton(
              onPressed: calcularTotal,
              child: const Text('Calcular total'),
            ),

            const SizedBox(height: 20),

            Text(resultado, style: const TextStyle(fontSize: 16)),
          ],
        ),
      ),
    );
  }
}
