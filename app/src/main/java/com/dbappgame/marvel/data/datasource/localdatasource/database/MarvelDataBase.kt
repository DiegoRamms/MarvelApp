package com.dbappgame.marvel.data.datasource.localdatasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dbappgame.marvel.data.datasource.localdatasource.database.dao.ComicsDAO
import com.dbappgame.marvel.data.datasource.localdatasource.database.dao.SeriesDAO
import com.dbappgame.marvel.data.datasource.localdatasource.model.ComicsEntity
import com.dbappgame.marvel.data.datasource.localdatasource.model.SeriesEntity

@Database(entities = [ComicsEntity::class, SeriesEntity::class], version = 1, exportSchema = false)
abstract class MarvelDataBase : RoomDatabase(){
    abstract fun getComicsDao(): ComicsDAO
    abstract fun getSeriesDao(): SeriesDAO
}