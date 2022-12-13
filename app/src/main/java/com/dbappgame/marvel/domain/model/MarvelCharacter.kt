package com.dbappgame.marvel.domain.model

data class MarvelCharacter(
        val id: Int,
        val name: String,
        val description: String,
        val modified: String,
        val urlImage: String?,
        val comic: List<Comic>
)
