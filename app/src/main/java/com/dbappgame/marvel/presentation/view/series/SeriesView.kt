package com.dbappgame.marvel.presentation.view.series

import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.domain.model.Series

interface SeriesView {
    fun setData(list: List<Series>)
    fun showError(message:String)
}