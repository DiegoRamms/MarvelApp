package com.dbappgame.marvel.data.repository

import android.util.Log
import androidx.room.Entity
import com.dbappgame.marvel.data.datasource.localdatasource.database.dao.ComicsDAO
import com.dbappgame.marvel.data.datasource.localdatasource.model.ComicsEntity
import com.dbappgame.marvel.data.datasource.networkdatasource.model.CharactersResponse
import com.dbappgame.marvel.data.datasource.networkdatasource.model.ComicsDTO
import com.dbappgame.marvel.data.mapper.toDomain
import com.dbappgame.marvel.data.datasource.networkdatasource.service.MarvelService
import com.dbappgame.marvel.data.mapper.toEntity
import com.dbappgame.marvel.domain.model.BaseResult
import com.dbappgame.marvel.domain.model.Comic
import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.domain.model.Series
import com.dbappgame.marvel.domain.repository.MarvelRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val service: MarvelService,
    private val comicsDAO: ComicsDAO
) :
    MarvelRepository {

    override fun getCharacters(): Single<BaseResult<List<MarvelCharacter>>> =
        service.getComics().map { BaseResult.Success(it.toDomain()) }




    override fun getComics(characterId: Int): Maybe<BaseResult<List<Comic>>> =
        comicsDAO.getAll(characterId).map { BaseResult.Success(it.toDomain()) }


    override fun getSeries(characterId: Int): Maybe<BaseResult<List<Series>>> {
        throw Exception("")
    }


    fun insertAll(response: CharactersResponse){


    }

    override fun insertData(marvelCharacter: List<MarvelCharacter>): Completable {
        val newLis = arrayListOf<ComicsEntity>()
        marvelCharacter.forEach { characters -> newLis.addAll( characters.comics.map {it.toEntity(characters.id)}) }
        return comicsDAO.insert(newLis)
    }
}