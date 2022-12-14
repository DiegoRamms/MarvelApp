package com.dbappgame.marvel.presentation.view.comics

import com.dbappgame.marvel.domain.model.Comic

interface ComicsView {
    fun setData(list: List<Comic>)
    fun showError(message:String)
}