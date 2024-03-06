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
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination="login"){
                        composable(route="login"){
                            LoginScreen(navController = navController)
                        }
                        composable(route="menu"){
                            MenuScreen(navController = navController)
                        }

                        composable(
                            route="perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument(name = "nome"){type = NavType.StringType},
                                navArgument(name = "idade"){type = NavType.IntType}
                            )
                        ){
                            val nome = it.arguments?.getString("nome")
                            val idade = it.arguments?.getInt("idade")
                            PerfilScreen(navController = navController, nome!!, idade!!)
                        }

                        composable(
                            route="pedidos?numero={numero}",
                            arguments = listOf(navArgument(name = "numero"){
                                defaultValue = "Sem valor"
                            })
                        )
                        {
                            PedidosScreen(navController = navController, it.arguments?.getString("numero")!!)
                        }
                    }

                }
            }
        }

    }
}
