package com.example.pokemon.service

// PokemonApiService.kt
import com.example.pokemon.response.PokemonResponse
import retrofit2.http.GET

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList(): PokemonResponse
}