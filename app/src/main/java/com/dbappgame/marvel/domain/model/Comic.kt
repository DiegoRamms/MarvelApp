package com.dbappgame.marvel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comic(
    val name: String,
    val resourceUri: String
): Parcelable


