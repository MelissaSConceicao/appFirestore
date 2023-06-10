package com.example.appfirestore.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.appfirestore.ui.theme.AppFirestoreTheme

//TELA PARA DEFINIR O BARRA DE MENU INFERIOR

//Objeto e atributos dos botões do menu
class BottomBarItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
)

//Lista de botões do menu
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
    ),
)

@Composable
fun BottomBar(
    item: BottomBarItem,
    modifier: Modifier = Modifier,
    items: List<BottomBarItem> = emptyList(),
    onItemChange: (BottomBarItem) -> Unit = {}
) {
    NavigationBar(modifier) {
        items.forEach {
            val label = it.label
            val icon = it.icon
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) },
                selected = item.label == label,
                onClick = {
                    onItemChange(it)
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomAppBarPreview() {
    AppFirestoreTheme() {
        BottomBar(
            item = bottomBarItems.first(),
            items = bottomBarItems
        )
    }
}