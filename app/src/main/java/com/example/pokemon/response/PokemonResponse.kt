package com.example.pokemon.response

// PokemonResponse.kt
data class PokemonResponse(
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String,
    val url: String
)
