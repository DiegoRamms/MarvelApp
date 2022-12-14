package com.dbappgame.marvel.data.datasource.localdatasource.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dbappgame.marvel.data.datasource.localdatasource.model.SeriesEntity
import com.dbappgame.marvel.domain.model.Series
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

@Dao
interface SeriesDAO {

    @Insert
    fun insert(list: List<SeriesEntity>): Completable

    @Query("DELETE FROM series")
    fun deleteAll(): Completable

    @Query("SELECT * FROM series WHERE characterId =:id")
    fun getAll(id: Int): Maybe<List<Series>>

}