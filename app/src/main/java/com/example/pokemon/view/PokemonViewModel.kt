package com.example.pokemon.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.response.Pokemon
import com.example.pokemon.service.impl.PokemonApiServiceImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                val response = PokemonApiServiceImpl.pokemonList.getPokemonList()
                _pokemonList.value = response.results
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}