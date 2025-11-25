package com.example.hellojetpackcompouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class VuelosScreen(val ruta: String) {
    object Home : VuelosScreen("vuelos_home")
    object Vuelos : VuelosScreen("vuelos_registro")
    object Reservas : VuelosScreen("vuelos_reservas")
}

class MainVuelosApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NavVuelosApp() }
    }
}

@Composable
fun NavVuelosApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = nav,
                startDestination = VuelosScreen.Home.ruta
            ) {
                composable(VuelosScreen.Home.ruta) { HomeVuelos(nav) }
                composable(VuelosScreen.Vuelos.ruta) { VuelosRegistro(nav) }
                composable(VuelosScreen.Reservas.ruta) { ReservasScreen(nav) }
            }
        }
    }
}

@Composable
fun HomeVuelos(nav: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Reserva de Vuelos",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { nav.navigate(VuelosScreen.Vuelos.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar vuelos")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(VuelosScreen.Reservas.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Planificador de reservas")
        }
    }
}

@Composable
fun VuelosRegistro(nav: NavController) {
    var vuelo1 by remember { mutableStateOf("") }
    var vuelo2 by remember { mutableStateOf("") }
    var vuelo3 by remember { mutableStateOf("") }

    val totalvuelos = vuelosPromedio(vuelo1, vuelo2, vuelo3)
    val mensaje = when {
        totalvuelos == 0.0 -> "Datos no válidos"
        totalvuelos >= 9.0 -> "Vuelo premium"
        totalvuelos >= 7.0 -> "Vuelo estándar"
        totalvuelos >= 5.0 -> "Vuelo básico"
        else -> "Vuelo no disponible"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Registrar vuelos",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = vuelo1,
            onValueChange = { vuelo1 = it },
            label = { Text("Vuelo 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = vuelo2,
            onValueChange = { vuelo2 = it },
            label = { Text("Vuelo 2") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = vuelo3,
            onValueChange = { vuelo3 = it },
            label = { Text("Vuelo 3") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Promedio = ${"%.2f".format(totalvuelos)}")
        Text(mensaje)

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}

@Composable
fun ReservasScreen(nav: NavController) {
    var preciototal by remember { mutableStateOf("") }
    var pagomes by remember { mutableStateOf("") }

    val meses = calcularMeses(preciototal, pagomes)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Planificador de Reservas",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = preciototal,
            onValueChange = { preciototal = it },
            label = { Text("Precio total ($)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = pagomes,
            onValueChange = { pagomes = it },
            label = { Text("Pago mensual ($)") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Meses necesarios = ${"%.1f".format(meses)}")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}

fun vuelosPromedio(v1: String, v2: String, v3: String): Double {
    val n1 = v1.replace(",", ".").toDoubleOrNull() ?: 0.0
    val n2 = v2.replace(",", ".").toDoubleOrNull() ?: 0.0
    val n3 = v3.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (n1 == 0.0 && n2 == 0.0 && n3 == 0.0) return 0.0
    return (n1 + n2 + n3) / 3.0
}

fun calcularMeses(precio: String, pago: String): Double {
    val p = precio.replace(",", ".").toDoubleOrNull() ?: 0.0
    val m = pago.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (p <= 0.0 || m <= 0.0) return 0.0
    return p / m
}

@Preview(showBackground = true)
@Composable
fun PreviewStatsNav() {
    NavVuelosApp()
}
