package com.dbappgame.marvel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Details(
    val character: List<MarvelCharacter>
): Parcelable
