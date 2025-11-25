package com.example.hellojetpackcompouse

import android.os.Bundle
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

data class Vuelo(val codigo: Int, val destino: String)

class MainNavegationRe : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NavReservaApp() }
    }
}

@Composable
fun NavReservaApp() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            val nav = rememberNavController()
            NavHost(navController = nav, startDestination = "lista") {

                composable("lista") {
                    ListaVuelos(
                        abrirDetalle = { codigo, destino ->
                            val seguro = URLEncoder.encode(destino, StandardCharsets.UTF_8.toString())
                            nav.navigate("detalle/$codigo/$seguro")
                        }
                    )
                }

                composable(
                    route = "detalle/{codigo}/{destino}",
                    arguments = listOf(
                        navArgument("codigo") { type = NavType.IntType },
                        navArgument("destino") { type = NavType.StringType }
                    )
                ) { datos ->
                    val codigo = datos.arguments?.getInt("codigo") ?: -1
                    val destino = datos.arguments?.getString("destino") ?: ""
                    DetalleVuelo(
                        codigo = codigo,
                        destino = destino,
                        volver = { nav.popBackStack() }
                    )
                }
            }
        }
    }
}

@Composable
fun ListaVuelos(abrirDetalle: (Int, String) -> Unit) {
    val vuelos = remember {
        listOf(
            Vuelo(101, "Quito"),
            Vuelo(202, "Guayaquil"),
            Vuelo(303, "Cuenca"),
            Vuelo(404, "Galápagos")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Lista de vuelos", style = MaterialTheme.typography.titleLarge)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(vuelos, key = { it.codigo }) { vuelo ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { abrirDetalle(vuelo.codigo, vuelo.destino) }
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Vuelo: ${vuelo.codigo} — Destino: ${vuelo.destino}")
                    }
                }
            }
        }
    }
}

@Composable
fun DetalleVuelo(codigo: Int, destino: String, volver: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Detalle del vuelo", style = MaterialTheme.typography.titleLarge)
        Card(Modifier.fillMaxWidth()) {
            Column(
                Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Código: $codigo", style = MaterialTheme.typography.titleMedium)
                Text("Destino: $destino", style = MaterialTheme.typography.bodyLarge)
            }
        }
        Button(onClick = volver) { Text("Volver") }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLista() { MaterialTheme { ListaVuelos { _, _ -> } } }

@Preview(showBackground = true)
@Composable
private fun PreviewDetalle() { MaterialTheme { DetalleVuelo(123, "Ejemplo", volver = {}) } }
