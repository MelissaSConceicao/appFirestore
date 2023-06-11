package com.example.appfirestore.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

//Objeto e atributos dos botões do menu
class BottomBarItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
)

//Configurando os botões do menu
val bottomBarItems = listOf(
    BottomBarItem(
        label = "Cadastrar",
        icon = Icons.Filled.Create,
        route = "cadastro"
    ),
    BottomBarItem(
        label = "Consultar",
        icon = Icons.Filled.Menu,
        route = "consulta"
    )
)