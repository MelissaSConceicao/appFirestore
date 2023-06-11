package com.example.appfirestore.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfirestore.model.Pessoa

//Definindo o estrutura do card de cada registro
@Composable
fun CardRegistro(pessoa: Pessoa) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(
            text = "${pessoa.Nome}",
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            modifier = Modifier.padding(14.dp, 12.dp)
        )
        Text(
            text = "CEP: ${pessoa.Cep}",
            fontSize = 15.sp,
            modifier = Modifier.padding(14.dp, 6.dp)
        )
        Text(
            text = "Endereço: ${pessoa.Endereco}",
            fontSize = 15.sp,
            modifier = Modifier.padding(14.dp, 6.dp)
        )
        Text(
            text = "Bairro: ${pessoa.Bairro}",
            fontSize = 15.sp,
            modifier = Modifier.padding(14.dp, 6.dp)
        )
        Text(
            text = "Cidade: ${pessoa.Cidade}",
            fontSize = 15.sp,
            modifier = Modifier.padding(14.dp, 6.dp)
        )
        Text(
            text = "Estado: ${pessoa.Estado}",
            fontSize = 15.sp,
            modifier = Modifier.padding(14.dp, 6.dp)
        )

        //Definindo botões para editar e excluir
        Row(modifier = Modifier.padding(14.dp, 6.dp, 0.dp, 12.dp)) {

            Button(
                onClick = { /* ... */ },
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    Icons.Rounded.Delete,
                    contentDescription = "",
                    modifier = Modifier.size(25.dp)
                )
            }

            Spacer(modifier = Modifier.size(12.dp))

            Button(
                onClick = { /* ... */ },
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    Icons.Rounded.Create,
                    contentDescription = "",
                    modifier = Modifier.size(20.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun CardRegistroPreview() {
    CardRegistro(
        Pessoa(
            Nome = "Nome da pessoa",
            Cep = "01010-010",
            Endereco = "Av. Rosa",
            Bairro = "Bairro Azul",
            Cidade = "Cidade Amarela",
            Estado = "ES"
        )
    )
}