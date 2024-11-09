package com.example.pokemon.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pokemon.response.Pokemon
import com.example.pokemon.view.PokemonViewModel
import androidx.compose.ui.platform.LocalContext

@Composable
fun PokemonListScreen(viewModel: PokemonViewModel = viewModel()) {
    val pokemonList by viewModel.pokemonList.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Pokemon List",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn {
            items(pokemonList) { pokemon ->
                PokemonListItem(pokemon)
            }
        }
    }
}

/*@Composable
fun PokemonList(pokemonList: List<Pokemon>, onPokemonClick: (Pokemon) -> Unit) {
    Column {
        pokemonList.forEach { pokemon ->
            PokemonListItem(
                pokemon = pokemon,
                onClick = { selectedPokemon ->
                    onPokemonClick(selectedPokemon)
                }
            )
        }
    }
}*/


/*@Composable
fun PokemonListItem(pokemon: Pokemon, navController: NavController) {
    Text(
        text = pokemon.name,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable(pokemon.url)
            //.clickable { onClick(pokemon) }
        //modifier = Modifier.padding(vertical = 8.dp)
    )
}*/

@Composable
fun PokemonListItem(pokemon: Pokemon) {
    val context = LocalContext.current
    Text(
        text = pokemon.name,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pokemon.url))
                context.startActivity(intent)
                //navController.navigate(pokemon.url)
            }
    )
}


