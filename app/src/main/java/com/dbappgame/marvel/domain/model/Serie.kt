package com.dbappgame.marvel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Series(
    val name: String,
    val resourceUri: String
): Parcelable
