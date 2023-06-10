package com.example.appfirestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appfirestore.model.Pessoa
import com.example.appfirestore.ui.components.BottomBar
import com.example.appfirestore.ui.components.BottomBarItem
import com.example.appfirestore.ui.components.bottomBarItems
import com.example.appfirestore.ui.screens.CadastrarScreen
import com.example.appfirestore.ui.screens.ConsultarScreen
import com.example.appfirestore.ui.screens.ConsultarTesteScreen
import com.example.appfirestore.ui.screens.listaRegistros
import com.example.appfirestore.ui.theme.AppFirestoreTheme
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

//TELA PRINCIPAL, ONDE VAI O NAVIGATION E O CONTROLE DAS TELAS

/*
O que fazer:
Criar um objeto Pessoa que tenha todos os atributos do registro
Criar um modelo do card de registro que será criado a cada registro
*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController= rememberNavController()
            val BackStackState by navController.currentBackStackEntryAsState()
            val currentDestination = BackStackState?.destination

            AppFirestoreTheme {
                Surface(modifier = Modifier.fillMaxSize())
                {
                    val selectedItem by remember(currentDestination) {
                        val item = currentDestination?.let{
                                destination -> bottomBarItems.find{
                            it.route == destination.route
                        }} ?: bottomBarItems.first()
                        mutableStateOf(item)
                    }
                    App(
                        bottomAppBarItemSelected = selectedItem,
                        onBottomAppBarItemSelectedChange = {
                            val route = it.route
                            navController.navigate(route){
                                launchSingleTop = true
                                popUpTo(route)
                            }
                        }
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "cadastro"){
                            composable("cadastro"){ CadastrarScreen() }
                            composable("consulta"){ ConsultarTesteScreen(listaRegistros) }
                        }
                    }
                }



            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    bottomAppBarItemSelected: BottomBarItem = bottomBarItems.first(),
    onBottomAppBarItemSelectedChange: (BottomBarItem) -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomBar(
                item = bottomAppBarItemSelected,
                items = bottomBarItems,
                onItemChange = onBottomAppBarItemSelectedChange
            ) }
    ) {
        Box(modifier = Modifier.padding(it)) {
            content()
        }
    }

}


