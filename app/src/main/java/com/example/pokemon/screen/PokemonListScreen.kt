package com.example.pokemon.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemon.response.Pokemon
import com.example.pokemon.view.PokemonViewModel

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

@Composable
fun PokemonListItem(pokemon: Pokemon) {
    Text(
        text = pokemon.name,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}
