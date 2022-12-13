package com.dbappgame.marvel.domain.repository

import com.dbappgame.marvel.domain.model.BaseResult
import com.dbappgame.marvel.domain.model.MarvelCharacter
import io.reactivex.rxjava3.core.Observable

interface MarvelRepository {
    fun getData(): Observable<BaseResult<List<MarvelCharacter>>>
}

