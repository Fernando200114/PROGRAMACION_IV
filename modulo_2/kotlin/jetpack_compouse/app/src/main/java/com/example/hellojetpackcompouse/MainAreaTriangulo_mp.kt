package com.example.hellojetpackcompouse



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Pantalla(val ruta: String) {
    object Inicio : Pantalla("inicio")
    object Colores : Pantalla("colores")
    object Calculos : Pantalla("calculos")
}

class MainReservaVuelos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AppReservaVuelos() }
    }
}

@Composable
fun AppReservaVuelos() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(navController = nav, startDestination = Pantalla.Inicio.ruta) {
                composable(Pantalla.Inicio.ruta) { PantallaInicio(nav) }
                composable(Pantalla.Colores.ruta) { PantallaColores(nav) }
                composable(Pantalla.Calculos.ruta) { PantallaCalculos(nav) }
            }
        }
    }
}

@Composable
fun PantallaInicio(nav: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Reserva de Vuelos", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { nav.navigate(Pantalla.Colores.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cambiar Color de Fondo")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(Pantalla.Calculos.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Tarifas")
        }
    }
}

@Composable
fun PantallaColores(nav: NavController) {
    var fondo by remember { mutableStateOf(Color(0xFF101828)) }
    var colorActual by remember { mutableStateOf("Azul oscuro") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Selector de Color", color = Color.White, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(12.dp))
            Text("Color actual: $colorActual", color = Color.White)
        }

        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { fondo = Color(0xFF0A84FF); colorActual = "Azul" }) { Text("Azul") }
                Button(onClick = { fondo = Color(0xFF34C759); colorActual = "Verde" }) { Text("Verde") }
                Button(onClick = { fondo = Color(0xFFFF9500); colorActual = "Naranja" }) { Text("Naranja") }
            }
            Spacer(Modifier.height(12.dp))
            Button(onClick = { nav.navigateUp() }, modifier = Modifier.fillMaxWidth()) {
                Text("Regresar")
            }
        }
    }
}

@Composable
fun PantallaCalculos(nav: NavController) {
    var distancia by remember { mutableStateOf("") }
    var tarifaBase by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var descuento by remember { mutableStateOf("") }

    val costo = calcularCosto(distancia, tarifaBase)
    val (precioFinal, ahorro) = calcularDescuento(precio, descuento)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Cálculos de Vuelo", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Costo por Distancia", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(value = distancia, onValueChange = { distancia = it }, label = { Text("Distancia (km)") })
                OutlinedTextField(value = tarifaBase, onValueChange = { tarifaBase = it }, label = { Text("Tarifa por km") })
                Text("Costo total = ${"%.2f".format(costo)}")
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Descuento", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(value = precio, onValueChange = { precio = it }, label = { Text("Precio") })
                OutlinedTextField(value = descuento, onValueChange = { descuento = it }, label = { Text("Descuento %") })
                Text("Precio final = ${"%.2f".format(precioFinal)}")
                Text("Ahorro = ${"%.2f".format(ahorro)}")
            }
        }

        Button(onClick = { nav.navigateUp() }, modifier = Modifier.fillMaxWidth()) {
            Text("Regresar")
        }
    }
}

fun calcularCosto(distancia: String, tarifa: String): Double {
    val d = distancia.replace(",", ".").toDoubleOrNull() ?: 0.0
    val t = tarifa.replace(",", ".").toDoubleOrNull() ?: 0.0
    return d * t
}

fun calcularDescuento(precio: String, descuento: String): Pair<Double, Double> {
    val p = precio.replace(",", ".").toDoubleOrNull() ?: 0.0
    val d = descuento.replace(",", ".").toDoubleOrNull() ?: 0.0
    val ahorro = p * (d / 100)
    val final = p - ahorro
    return final to ahorro
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    AppReservaVuelos()
}
