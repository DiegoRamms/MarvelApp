package com.dbappgame.marvel.presentation.view

import com.dbappgame.marvel.domain.model.MarvelCharacter

interface CharactersView {
    fun loadView(isLoading: Boolean)
    fun showList(list: List<MarvelCharacter>)
    fun showError(error: String)
}