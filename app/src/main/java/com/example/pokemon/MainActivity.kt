/*package com.example.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokemon.ui.theme.PokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Tozogabee",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokemonTheme {
        Greeting("Tozogabee")
    }
}*/
package com.example.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemon.screen.PokemonListScreen
import com.example.pokemon.ui.theme.PokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("Pokemon App") })
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("list") { ListScreen(navController) }
            composable("pokemonList") { PokemonListScreen() }
            composable("detail") { DetailScreen() }
            composable("favourites") { FavouritesScreen() }
        }
    }
}

@Composable
fun ListScreen(navController: androidx.navigation.NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        //Text(text = "Pokemon List", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = { navController.navigate("PokemonList") }) {
            Text("Go to List")
        }
        Button(onClick = { navController.navigate("detail") }) {
            Text("Go to Detail")
        }
        Button(onClick = { navController.navigate("favourites") }) {
            Text("Go to Favourites")
        }
    }
}

/*@Composable
fun PokemonListScreen() {
    Text(text = "Pokemon List", modifier = Modifier.padding(16.dp))
}*/

@Composable
fun DetailScreen() {
    Text(text = "Pokemon Detail", modifier = Modifier.padding(16.dp))
}

@Composable
fun FavouritesScreen() {
    Text(text = "Pokemon Favourites", modifier = Modifier.padding(16.dp))
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PokemonTheme {
        MainScreen()
    }
}
