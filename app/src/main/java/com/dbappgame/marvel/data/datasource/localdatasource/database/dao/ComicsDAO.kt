package com.dbappgame.marvel.data.datasource.localdatasource.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dbappgame.marvel.data.datasource.localdatasource.model.ComicsEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

@Dao
interface ComicsDAO {

    @Insert
    fun insert(list: List<ComicsEntity>): Completable

    @Query("DELETE FROM comics")
    fun deleteAll(): Completable

    @Query("SELECT * FROM comics WHERE characterId =:id")
    fun getAll(id: Int): Maybe<List<ComicsEntity>>
}