package com.example.hellojetpackcompouse



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

sealed class VueloScreen(val route: String) {
    object Home : VueloScreen("vuelos_home")
    object Reserva : VueloScreen("vuelos_reserva")
    object Conversion : VueloScreen("vuelos_conversion")
}

class MainVuelosApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { VueloNavApp() }
    }
}

@Composable
fun VueloNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = nav,
                startDestination = VueloScreen.Home.route
            ) {
                composable(VueloScreen.Home.route) { VuelosHomeScreen(nav) }
                composable(VueloScreen.Reserva.route) { ReservaScreen(nav) }
                composable(VueloScreen.Conversion.route) { ConversionScreen(nav) }
            }
        }
    }
}

@Composable
fun VuelosHomeScreen(nav: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Panel de Vuelos",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { nav.navigate(VueloScreen.Reserva.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            )
        ) {
            Text("Crear reserva de vuelo")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(VueloScreen.Conversion.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Blue
            )
        ) {
            Text("Convertir unidades")
        }
    }
}

@Composable
fun ReservaScreen(nav: NavController) {
    var precio by remember { mutableStateOf("") }
    var impuesto by remember { mutableStateOf("") }

    val valorImpuesto = calcularImpuesto(precio, impuesto)
    val totalPagar = calcularTotal(precio, impuesto)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Reserva de Vuelo",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio del vuelo ($)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = impuesto,
            onValueChange = { impuesto = it },
            label = { Text("Impuesto (%)") },
            modifier = Modifier.fillMaxWidth()
        )
        Text("Impuesto = ${"%.2f".format(valorImpuesto)} $")
        Text("Total = ${"%.2f".format(totalPagar)} $")
        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}

@Composable
fun ConversionScreen(nav: NavController) {
    var km by remember { mutableStateOf("") }
    var millas by remember { mutableStateOf("") }

    val kmToMi = convertirKmMillas(km)
    val miToKm = convertirMillasKm(millas)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Conversor de Unidades",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Kilómetros a Millas", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = km,
                    onValueChange = { km = it },
                    label = { Text("Kilómetros") }
                )
                Text("Resultado: ${"%.2f".format(kmToMi)} mi")
            }
        }
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Millas a Kilómetros", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = millas,
                    onValueChange = { millas = it },
                    label = { Text("Millas") }
                )
                Text("Resultado: ${"%.2f".format(miToKm)} km")
            }
        }
        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}

fun calcularImpuesto(precio: String, impuesto: String): Double {
    val p = precio.replace(",", ".").toDoubleOrNull() ?: 0.0
    val i = impuesto.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (p < 0.0 || i < 0.0) return 0.0
    return p * (i / 100.0)
}

fun calcularTotal(precio: String, impuesto: String): Double {
    val p = precio.replace(",", ".").toDoubleOrNull() ?: 0.0
    val i = impuesto.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (p < 0.0 || i < 0.0) return 0.0
    return p + calcularImpuesto(precio, impuesto)
}

fun convertirKmMillas(km: String): Double {
    val k = km.replace(",", ".").toDoubleOrNull() ?: 0.0
    return k * 0.621371
}

fun convertirMillasKm(mi: String): Double {
    val m = mi.replace(",", ".").toDoubleOrNull() ?: 0.0
    return m * 1.60934
}

@Preview(showBackground = true)
@Composable
fun PreviewVuelosNav() {
    VueloNavApp()
}
