package com.dbappgame.marvel.data.datasource.networkdatasource.model


import com.google.gson.annotations.SerializedName

data class SeriesDTO(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("returned")
    val returned: Int
)