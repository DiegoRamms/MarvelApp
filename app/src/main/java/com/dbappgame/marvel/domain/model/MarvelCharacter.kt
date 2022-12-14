package com.dbappgame.marvel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarvelCharacter(
        val id: Int,
        val name: String,
        val description: String,
        val modified: String,
        val urlImage: String,
        val comics: List<Comic>,
        val series: List<Series>
): Parcelable
