package com.dbappgame.marvel.data.datasource.localdatasource.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "series")
data class SeriesEntity(
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val resourceUri: String,
    @ColumnInfo
    val characterId: Int
) {
    @PrimaryKey
    var id: Long = 0
}
