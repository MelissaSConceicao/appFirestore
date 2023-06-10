package com.example.appfirestore.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfirestore.model.Pessoa
import com.example.appfirestore.ui.components.CardRegistro
import com.google.firebase.firestore.FirebaseFirestore

val listaRegistros = mutableListOf(
    Pessoa(
        Nome = "nome",
        Cep = "cep",
        Endereco = "end",
        Bairro = "bai",
        Cidade = "cid",
        Estado = "est"
    )
)

@Composable
fun ConsultarTesteScreen(registros: List<Pessoa>) {
    val db = FirebaseFirestore.getInstance()

    db.collection("usuarios").get()
        .addOnSuccessListener { querySnapshot->
            //A melhor opção é usar documents e cada índice se refere a um registro
            Log.i("Main Activity", "Teste com docs[0]: ${querySnapshot.documents[0].data}")
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
        //O esperado é, a cada objeto criado, é criado um card também
        for (p in registros) {
            CardRegistro(pessoa = p)
        }
}




}








/*
    @Composable
    fun getCollection() {
        db.collection("usuarios")
            .get()
            .addOnSuccessListener {
                 querySnapshot ->
                 OBS: documento é uma variavel int

                        for (documento in querySnapshot.documents) {
                            /*
                            Esse "documents.data", junto ao loop, me traz exatamente os dados de todos os
                            registros, sem informações adicionais
                            Log.i("Main Activity", "Registro encontrado: ${documento.data}")
                            */
                            documento.data?.let { dadosPessoa ->
                                val txtNome = dadosPessoa["nome"] as String
                                val txtCep = dadosPessoa["cep"] as String
                                val txtEndereco = dadosPessoa["endereco"] as String
                                Cards(Nome = txtNome, Cep = txtCep, Endereco = txtEndereco)
                            }

                        }//laço for
            }

    }

*/






