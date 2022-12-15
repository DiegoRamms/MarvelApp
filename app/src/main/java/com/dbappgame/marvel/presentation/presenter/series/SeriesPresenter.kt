package com.dbappgame.marvel.presentation.presenter.series

interface SeriesPresenter {
    fun getData(characterId: Int)
    fun onDestroy()
}