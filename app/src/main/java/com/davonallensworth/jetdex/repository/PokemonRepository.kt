package com.davonallensworth.jetdex.repository

import com.davonallensworth.jetdex.data.remote.PokeApi
import com.davonallensworth.jetdex.data.remote.responses.Pokemon
import com.davonallensworth.jetdex.data.remote.responses.PokemonList
import com.davonallensworth.jetdex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch(e: Exception) {
            return Resource.Error("An unknown error has occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch(e: Exception) {
            return Resource.Error("An unknown error has occurred.")
        }
        return Resource.Success(response)
    }
}