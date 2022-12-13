package com.dbappgame.marvel.data.service

import com.dbappgame.marvel.data.model.CharactersResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface MarvelService {
    @GET("comics")
    fun getComics(): Observable<CharactersResponse>
}