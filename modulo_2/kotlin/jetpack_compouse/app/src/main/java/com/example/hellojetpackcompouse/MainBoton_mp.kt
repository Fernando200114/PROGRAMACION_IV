package com.example.hellojetpackcompouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainBotonRe : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AppReservaVuelo() }
    }
}

@Composable
fun AppReservaVuelo() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            ReservaVueloScreen()
        }
    }
}

@Composable
fun ReservaVueloScreen() {
    var reserva by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(if (reserva) "reserva confirmada ✈️" else "sin reserva ❌")

        Button(onClick = { reserva = !reserva }) {
            Text(if (reserva) "cancelar reserva" else "reservar vuelo")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ReservaPreview() { AppReservaVuelo() }
