package br.com.lucas.navegandoentretelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.lucas.navegandoentretelas.screens.LoginScreen
import br.com.lucas.navegandoentretelas.screens.MenuScreen
import br.com.lucas.navegandoentretelas.screens.PedidosScreen
import br.com.lucas.navegandoentretelas.screens.PerfilScreen
import br.com.lucas.navegandoentretelas.ui.theme.NavegandoEntreTelasTheme

open class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)

        setContent {
            NavegandoEntreTelasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    //Criando instancia do NavController através da função rememberNavController
                    val navController = rememberNavController()

                    //Função NavHost responsável por gerenciar as rotas
                    //O NavHost utiliza o NavController que possui o backstack e o startDestination
                    NavHost(navController = navController, startDestination="login"){
                        composable(route="login"){ LoginScreen(navController = navController)}
                        composable(route="menu"){MenuScreen(navController = navController)}
                        composable(route="perfil"){PerfilScreen(navController = navController)}
                        composable(route="pedidos"){PedidosScreen(navController = navController)}
                    }

                }
            }
        }

    }
}
