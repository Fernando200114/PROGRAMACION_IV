package com.example.hellojetpackcompouse



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class personaitem(val codigo: Int, val nombre: String, val cargo: String)

class MainlistaEditableRe : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { listaapp() }
    }
}

@Composable
fun listaapp() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) { listascreen() }
    }
}

@Composable
fun listascreen() {
    var autokey by rememberSaveable { mutableStateOf(4) }
    val personas = remember {
        mutableStateListOf(
            personaitem(1, "ana torres", "disenadora"),
            personaitem(2, "luis perez", "desarrollador"),
            personaitem(3, "maria lopez", "tester"),
            personaitem(4, "carlos ruiz", "jefe proyecto")
        )
    }

    var nombreinput by rememberSaveable { mutableStateOf("") }
    var cargoinput by rememberSaveable { mutableStateOf("") }

    var seleccionado by remember { mutableStateOf<personaitem?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("lista personas", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = nombreinput,
            onValueChange = { nombreinput = it },
            label = { Text("nombre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cargoinput,
            onValueChange = { cargoinput = it },
            label = { Text("cargo") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(onClick = {
                nombreinput = ""
                cargoinput = ""
            }) {
                Text("limpiar")
            }

            Spacer(Modifier.width(8.dp))

            Button(
                onClick = {
                    val n = nombreinput.trim()
                    val c = cargoinput.trim()
                    if (n.isNotEmpty() && c.isNotEmpty()) {
                        autokey += 1
                        personas.add(personaitem(autokey, n, c))
                        nombreinput = ""
                        cargoinput = ""
                    }
                },
                enabled = nombreinput.isNotBlank() && cargoinput.isNotBlank()
            ) {
                Text("agregar")
            }
        }

        HorizontalDivider()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(personas, key = { it.codigo }) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { seleccionado = item }
                        ) {
                            Text(item.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(item.cargo, style = MaterialTheme.typography.bodyMedium)
                        }

                        TextButton(onClick = {
                            personas.removeIf { it.codigo == item.codigo }
                            if (seleccionado?.codigo == item.codigo) seleccionado = null
                        }) {
                            Text("eliminar")
                        }
                    }
                }
            }
        }

        if (seleccionado != null) {
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(12.dp)) {
                    Text("detalle", style = MaterialTheme.typography.titleMedium)
                    Text("id: ${seleccionado!!.codigo}")
                    Text("nombre: ${seleccionado!!.nombre}")
                    Text("cargo: ${seleccionado!!.cargo}")
                }
            }
        } else {
            Text("elige una persona para ver detalle")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewEditable() {
    listaapp()
}
