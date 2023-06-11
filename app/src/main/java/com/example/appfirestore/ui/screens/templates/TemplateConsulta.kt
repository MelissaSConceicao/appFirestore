package com.example.appfirestore.ui.screens.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TemplateConsulta() {
    Column(modifier = Modifier
        .padding(8.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

        Card(modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .padding(4.dp),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = "Nome da pessoa",
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(14.dp, 12.dp))
            Text(
                text = "CEP:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Endereço:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Bairro:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Cidade:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Estado:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp, 0.dp, 12.dp))

        }

        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = "Nome da pessoa",
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(14.dp, 12.dp))
            Text(
                text = "CEP:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Endereço:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Bairro:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Cidade:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Estado:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))

            Row(modifier = Modifier.padding(14.dp, 6.dp, 0.dp, 12.dp)) {

                Button(onClick = { /* ... */ },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        Icons.Rounded.Delete,
                        contentDescription = "",
                        modifier = Modifier.size(25.dp)
                    )
                }
                Spacer(modifier = Modifier.size(12.dp))

                Button(onClick = { /* ... */ },
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

        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = "Nome da pessoa",
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(14.dp, 12.dp))
            Text(
                text = "CEP:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Endereço:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Bairro:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Cidade:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))
            Text(
                text = "Estado:",
                fontSize = 15.sp,
                modifier = Modifier.padding(14.dp, 6.dp))

            Row(modifier = Modifier.padding(14.dp, 6.dp, 0.dp, 12.dp)) {

                Button(onClick = { /* ... */ },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        Icons.Rounded.Delete,
                        contentDescription = "",
                        modifier = Modifier.size(25.dp)
                    )
                }
                Spacer(modifier = Modifier.size(12.dp))

                Button(onClick = { /* ... */ },
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
}


@Preview(showSystemUi = true)
@Composable
fun TemplateConsultaPreview() {
    TemplateConsulta()
}