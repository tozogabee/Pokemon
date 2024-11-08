package com.example.pokemon.service.impl

import com.example.pokemon.service.PokemonApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonApiServiceImpl {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    val pokemonList: PokemonApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApiService::class.java)
    }
}