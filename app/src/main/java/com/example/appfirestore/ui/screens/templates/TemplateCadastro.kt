package com.example.appfirestore.ui.screens.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemplateCadastro() {
    val nome = remember { mutableStateOf("") }
    val endereco = remember { mutableStateOf("") }
    val bairro = remember { mutableStateOf("") }
    val cep = remember { mutableStateOf("") }
    val cidade = remember { mutableStateOf("") }
    val estado = remember { mutableStateOf("") }


    Column(
        Modifier
            .padding(15.dp, 18.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
            ,
            value = nome.value,
            onValueChange = { nome.value = it },
            label = { Text("Nome") }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
            ,
            value = endereco.value,
            onValueChange = { endereco.value = it },
            label = { Text("Endereço") }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
            ,
            value = bairro.value,
            onValueChange = { bairro.value = it },
            label = { Text("Bairro") }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
            ,
            value = cep.value,
            onValueChange = { cep.value = it },
            label = { Text("CEP") }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
            ,
            value = cidade.value,
            onValueChange = { cidade.value = it },
            label = { Text("Cidade") }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = estado.value,
            onValueChange = { estado.value = it },
            label = { Text("Estado") }
        )

        Button(
            onClick = {/*TODO*/},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text ="Cadastrar",
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp, 4.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TemplateCadastroPreview() {
    TemplateCadastro()
}