package com.example.appfirestore.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appfirestore.model.Pessoa
import com.example.appfirestore.model.listaRegistros
import com.example.appfirestore.ui.components.CardRegistro
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ConsultarScreen(registros: List<Pessoa>) {
    val db = FirebaseFirestore.getInstance()

    //Pegando todos os dados da coleção "usuarios"
    db.collection("usuarios").get()
        .addOnSuccessListener { querySnapshot ->
            //Esse comando imprime os dados do priemiro cadastro da coleção
            //Log.i("Main Activity", "dados com documents[0]: ${querySnapshot.documents[0].data}")

            for (indice in querySnapshot.documents){
                indice.data?.let { dadosPessoa ->
                    var nome = dadosPessoa["nome"] as String
                    var cep = dadosPessoa["cep"] as String
                    var end = dadosPessoa["endereco"] as String
                    var bai = dadosPessoa["bairro"] as String
                    var cid = dadosPessoa["cidade"] as String
                    var est = dadosPessoa["estado"] as String
                    //listaRegistros.add(Pessoa(nome, cep, end bairro....))
                    listaRegistros.add(
                        Pessoa(
                            Nome = nome,
                            Cep = cep,
                            Endereco = end,
                            Bairro = bai,
                            Cidade =  cid,
                            Estado = est
                        )
                    )
                }

            }

        }

    Column(modifier = Modifier
        .padding(8.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        //Para cada objeto criado, é criado um card também
        for (p in registros.indices) {
            CardRegistro(pessoa = registros[p])
        }
    }
}