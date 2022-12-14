package com.dbappgame.marvel.data.datasource.networkdatasource.model


import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("attributionText")
    val attributionText: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("data")
    val info: Data,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("status")
    val status: String
)