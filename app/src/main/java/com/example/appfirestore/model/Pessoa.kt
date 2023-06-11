package com.example.appfirestore.model

//Objeto e atributos do registro a ser enviado ao Firestore
class Pessoa(
    var Nome: String,
    var Cep: String,
    var Endereco: String,
    var Bairro: String,
    var Cidade: String,
    var Estado: String
)

//Definindo uma lista para os registros
val listaRegistros = mutableListOf(
    Pessoa(
        Nome = "nome",
        Cep = "cep",
        Endereco = "endereco",
        Bairro = "bairro",
        Cidade = "cidade",
        Estado = "estado"
    )
)
