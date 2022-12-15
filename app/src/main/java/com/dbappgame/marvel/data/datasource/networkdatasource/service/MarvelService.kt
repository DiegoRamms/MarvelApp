package com.dbappgame.marvel.data.datasource.networkdatasource.service

import com.dbappgame.marvel.data.datasource.networkdatasource.model.CharactersResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MarvelService {
    @GET("characters")
    fun getCharacters(): Single<CharactersResponse>
}