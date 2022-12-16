package com.dbappgame.marvel.presentation.view.details

import com.dbappgame.marvel.domain.model.Comic
import com.dbappgame.marvel.domain.model.MarvelCharacter

interface DetailsView {
    fun setData(list: List<Comic>)
    fun showError(message:String)
}