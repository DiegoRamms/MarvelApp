package com.dbappgame.marvel.data.mapper


import com.dbappgame.marvel.data.datasource.networkdatasource.model.CharactersResponse
import com.dbappgame.marvel.data.datasource.networkdatasource.model.ComicsDTO
import com.dbappgame.marvel.data.datasource.networkdatasource.model.SeriesDTO
import com.dbappgame.marvel.domain.model.Comic
import com.dbappgame.marvel.domain.model.MarvelCharacter
import com.dbappgame.marvel.domain.model.Series


// NETWORK MAPPERS

fun CharactersResponse.toDomain(): List<MarvelCharacter> {
    val result = info.results

    return result.map {
        MarvelCharacter(
            id = it.id ?: 0,
            name = it.name ?: "",
            description = it.description ?: "",
            modified = it.modified ?: "",
            urlImage = "${it.thumbnail.path.replace("http", "https")}.${it.thumbnail.extension}",
            comics = it.comicsDTO.toDomain(),
            series = it.seriesDTO.toDomain()
        )
    }
}

private fun ComicsDTO.toDomain() : List<Comic> =
    items.map { Comic(name = it.name, resourceUri = it.resourceURI) }

private fun SeriesDTO.toDomain(): List<Series> =
    items.map { Series(name = it.name, resourceUri = it.resourceURI) }






