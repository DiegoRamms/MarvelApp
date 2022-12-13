package com.dbappgame.marvel.data.mapper

import com.dbappgame.marvel.data.model.CharactersResponse
import com.dbappgame.marvel.domain.model.MarvelCharacter


fun CharactersResponse.toDomain(): List<MarvelCharacter> {
    val result = info.results

    return result.map {
        MarvelCharacter(
            id = it.id ,
            name = it.name ,
            description = it.description,
            modified = it.modified,
            urlImage = "${it.thumbnail.path}${it.thumbnail.extension}",
            comic = emptyList()
        )
    }

}
