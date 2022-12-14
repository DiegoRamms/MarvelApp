package com.dbappgame.marvel.presentation.view.charecter

import com.dbappgame.marvel.domain.model.MarvelCharacter

interface CharactersView {
    fun loadView(isLoading: Boolean)
    fun setData(list: List<MarvelCharacter>)
    fun showError(error: String)
}