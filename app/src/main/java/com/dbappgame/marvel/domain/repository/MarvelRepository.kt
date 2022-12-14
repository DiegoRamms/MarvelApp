package com.dbappgame.marvel.domain.repository

import com.dbappgame.marvel.domain.model.BaseResult
import com.dbappgame.marvel.domain.model.Comic
import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.domain.model.Series
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface MarvelRepository {
    fun getCharacters(): Single<BaseResult<List<MarvelCharacter>>>


}

