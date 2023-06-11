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
import com.example.appfirestore.model.BottomBarItem
import com.example.appfirestore.model.bottomBarItems
import com.example.appfirestore.ui.theme.AppFirestoreTheme

//Definindo a barra do menu inferior
@Composable
fun BottomBar(
    item: BottomBarItem,
    items: List<BottomBarItem> = emptyList(),
    onItemChange: (BottomBarItem) -> Unit = {}
) {
    NavigationBar() {
        items.forEach {
            val label = it.label
            val icon = it.icon
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) },
                selected = item.label == label,
                onClick = { onItemChange(it) }
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