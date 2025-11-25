package com.example.hellojetpackcompouse


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class FlightScreen(val route: String) {
    object Menu : FlightScreen("menu")
    object Reservar : FlightScreen("reservar")
    object Consultar : FlightScreen("consultar")
}

class MainReservas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { FlightNavApp() }
    }
}

@Composable
fun FlightNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = nav,
                startDestination = FlightScreen.Menu.route
            ) {
                composable(FlightScreen.Menu.route) { MenuScreen(nav) }
                composable(FlightScreen.Reservar.route) { ReservarScreen(nav) }
                composable(FlightScreen.Consultar.route) { ConsultarScreen(nav) }
            }
        }
    }
}

@Composable
fun MenuScreen(nav: NavHostController) {
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
            onClick = { nav.navigate(FlightScreen.Reservar.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reservar Vuelo")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(FlightScreen.Consultar.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Consultar Vuelos")
        }
    }
}

@Composable
fun ReservarScreen(nav: NavController) {
    var pasajero by remember { mutableStateOf("") }
    var destino by remember { mutableStateOf("") }

    val resultado = calcularReserva(pasajero, destino)
    val estado = estadoReserva(resultado)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Reserva de Vuelo",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(id = R.drawable.health),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )

        OutlinedTextField(
            value = pasajero,
            onValueChange = { pasajero = it },
            label = { Text("Nombre del pasajero") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = destino,
            onValueChange = { destino = it },
            label = { Text("Destino") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Código reserva: $resultado")
        Text(estado)

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}

@Composable
fun ConsultarScreen(nav: NavController) {
    var vuelo by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }

    val salida = vueloSalida(vuelo)
    val llegada = vueloLlegada(fecha)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Consulta de Vuelos",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Vuelo → Ciudad", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = vuelo,
                    onValueChange = { vuelo = it },
                    label = { Text("Código del Vuelo") }
                )
                Text("Ciudad: $salida")
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Fecha → Estado del vuelo", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = fecha,
                    onValueChange = { fecha = it },
                    label = { Text("Fecha") }
                )
                Text("Estado: $llegada")
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

fun calcularReserva(nombre: String, destino: String): String {
    if (nombre.isBlank() || destino.isBlank()) return "0"
    return (nombre.length * destino.length).toString()
}

fun estadoReserva(valor: String): String {
    return if (valor == "0") "Datos incompletos"
    else "Reserva Generada"
}

fun vueloSalida(cod: String): String {
    if (cod.isBlank()) return "Sin datos"
    return "Quito"
}

fun vueloLlegada(fecha: String): String {
    if (fecha.isBlank()) return "Sin datos"
    return "A tiempo"
}

@Preview(showBackground = true)
@Composable
fun PreviewFlightNav() {
    FlightNavApp()
}
