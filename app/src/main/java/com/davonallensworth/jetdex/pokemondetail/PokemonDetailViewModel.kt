package com.davonallensworth.jetdex.pokemondetail

import androidx.lifecycle.ViewModel
import com.davonallensworth.jetdex.data.remote.responses.Pokemon
import com.davonallensworth.jetdex.repository.PokemonRepository
import com.davonallensworth.jetdex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}