package com.dbappgame.marvel.presentation.presenter.comics

import com.dbappgame.marvel.domain.model.Comic

interface ComicsPresenter {
    fun getData(characterId: Int)
    fun onDestroy()
}