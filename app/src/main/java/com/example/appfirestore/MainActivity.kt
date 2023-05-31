package com.example.appfirestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appfirestore.ui.theme.AppFirestoreTheme
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFirestoreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Formulario()
                }
            }
        }
    }
}

@Composable
fun Formulario() {
    Column(
        Modifier
            .padding(5.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        //Campos do formulário
        Campos()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Campos() {
    val db = FirebaseFirestore.getInstance()

    val nome = remember { mutableStateOf("") }
    val endereco = remember { mutableStateOf("") }
    val bairro = remember { mutableStateOf("") }
    val cep = remember { mutableStateOf("") }
    val cidade = remember { mutableStateOf("") }
    val estado = remember { mutableStateOf("") }

    OutlinedTextField(
        value = nome.value,
        onValueChange = { nome.value = it },
        label = { Text("Nome") }
    )

    OutlinedTextField(
        value = endereco.value,
        onValueChange = { endereco.value = it },
        label = { Text("Endereço") }
    )

    OutlinedTextField(
        value = bairro.value,
        onValueChange = { bairro.value = it },
        label = { Text("Bairro") }
    )

    OutlinedTextField(
        value = cep.value,
        onValueChange = { cep.value = it },
        label = { Text("CEP") }
    )

    OutlinedTextField(
        value = cidade.value,
        onValueChange = { cidade.value = it },
        label = { Text("Cidade") }
    )

    OutlinedTextField(
        value = estado.value,
        onValueChange = { estado.value = it },
        label = { Text("Estado") }
    )

    Button(
        onClick = {
            val pessoa = hashMapOf(
                "bairro" to bairro.value,
                "cep" to cep.value,
                "cidade" to cidade.value,
                "endereco" to endereco.value,
                "estado" to estado.value,
                "nome" to nome.value,
            )
            db.collection("usuarios")
                .add(pessoa)

            nome.value = ""
            endereco.value = ""
            bairro.value = ""
            cep.value = ""
            cidade.value = ""
            estado.value = ""
        },
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text("Cadastrar")
    }
}