package com.dbappgame.marvel.data.repository

import com.dbappgame.marvel.data.mapper.toDomain
import com.dbappgame.marvel.data.datasource.networkdatasource.service.MarvelService
import com.dbappgame.marvel.domain.model.BaseResult
import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.domain.repository.MarvelRepository
import io.reactivex.rxjava3.core.Single

import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val service: MarvelService,
) :
    MarvelRepository {

    override fun getCharacters(): Single<BaseResult<List<MarvelCharacter>>> =
        service.getComics().map { BaseResult.Success(it.toDomain()) }

}